package com.keepzzz.film.interceptor;

import com.google.gson.Gson;
import com.keepzzz.film.base.ApiResponse;
import com.keepzzz.film.enums.Status;
import com.keepzzz.film.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    private static final Gson gson = new Gson();


    /**
     * 调用接口时进行拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        if(token == null){
            token = request.getParameter("token");
        }
        if(token != null){
            Claims claims = JwtUtil.checkJWT(token);
            if(claims != null){
                 Integer userId = (Integer)claims.get("id");
                 String username =(String) claims.get("username");

                 request.setAttribute("user_id",userId);
                 request.setAttribute("username",username);

                 return true;
            }
        }
        sendJsonMessage(response, ApiResponse.ofStatus(Status.NOT_LOGIN));
        return false;
    }

    /**
     * 响应数据给前端
     * @param response
     * @param object
     */
    public static void sendJsonMessage(HttpServletResponse response,Object object){
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.println(gson.toJson(object));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }
}
