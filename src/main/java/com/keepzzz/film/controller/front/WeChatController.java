package com.keepzzz.film.controller.front;

import com.keepzzz.film.config.WeChatConfig;
import com.keepzzz.film.utils.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;

@RestController
@RequestMapping("/api/v1/wechat")
public class WeChatController {


    @Autowired
    private WeChatConfig weChatConfig;

    @RequestMapping("/order/callback")
    public void orderCallback(HttpServletRequest request, HttpServletResponse response) throws Exception {

        InputStream inputStream =  request.getInputStream();

        //BufferedReader是包装设计模式，性能更搞
        BufferedReader in =  new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        StringBuffer sb = new StringBuffer();
        String line ;
        while ((line = in.readLine()) != null){
            sb.append(line);
        }
        in.close();
        inputStream.close();
        Map<String,String> callbackMap = WXPayUtil.xmlToMap(sb.toString());
        System.out.println(callbackMap.toString());

        SortedMap<String,String> sortedMap = WXPayUtil.getSortedMap(callbackMap);

        //判断签名是否正确
        if(WXPayUtil.isCorrectSign(sortedMap,weChatConfig.getKey())){

            if("SUCCESS".equals(sortedMap.get("result_code"))){

                String outTradeNo = sortedMap.get("out_trade_no");

//                VideoOrder dbVideoOrder = videoOrderService.findByOutTradeNo(outTradeNo);
//
//                if(dbVideoOrder != null && dbVideoOrder.getState()==0){  //判断逻辑看业务场景
//                    VideoOrder videoOrder = new VideoOrder();
//                    videoOrder.setOpenid(sortedMap.get("openid"));
//                    videoOrder.setOutTradeNo(outTradeNo);
//                    videoOrder.setNotifyTime(new Date());
//                    videoOrder.setState(1);
//                    int rows = videoOrderService.updateVideoOderByOutTradeNo(videoOrder);
//                    if(rows == 1){ //通知微信订单处理成功
//                        response.setContentType("text/xml");
//                        response.getWriter().println("success");
//                        return;
//                    }
//                }
            }
        }
        //都处理失败
        response.setContentType("text/xml");
        response.getWriter().println("fail");

    }


}
