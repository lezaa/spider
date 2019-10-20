package com.keepzzz.film.controller.front;

import com.keepzzz.film.base.ApiResponse;
import com.keepzzz.film.dto.UserInfo;
import com.keepzzz.film.enums.Status;
import com.keepzzz.film.service.UserService;
import com.keepzzz.film.vo.LoginVO;
import com.keepzzz.film.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 按照账号密码登陆
     * @param loginVO
     * @param bindingResult
     * @return
     */
    @PostMapping("/login")
    public ApiResponse login(@Validated @RequestBody LoginVO loginVO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ApiResponse.ofStatus(Status.NOT_VALID_PARAM);
        }
        boolean flag = userService.login(loginVO.getUsername(), loginVO.getPassword());
        if(flag){
            return ApiResponse.ofSuccess();
        }
        return  ApiResponse.ofStatus(Status.ACCOUNT_ERROR);
    }


    /**
     * 用户注册接口
     * @param registerVO
     * @param bindingResult
     * @return
     */
    @PostMapping("/register")
    public ApiResponse register(@Validated @RequestBody RegisterVO registerVO,BindingResult bindingResult){
        System.out.println(registerVO.getRealName());
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors().toString());
            return ApiResponse.ofStatus(Status.NOT_VALID_PARAM);

        }
        boolean flag = userService.register(registerVO);
        if(flag){
            return ApiResponse.ofSuccess();
        }
        return ApiResponse.ofStatus(Status.Not_SUPPORTED_OPERATION);
    }

    /**
     * 修改用户信息
     * <p>用户修改头像,性别,电话,头像</p>
     * @return
     */
    @PostMapping("/info")
    public ApiResponse updateUserInfo(@Validated UserInfo userInfo,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ApiResponse.ofStatus(Status.NOT_VALID_PARAM);
        }
        boolean flag = userService.editUserInfo(userInfo);
        if(flag){
            return ApiResponse.ofSuccess();
        }
        return ApiResponse.ofStatus(Status.BAD_REQUEST);
    }


    /**
     * 获取用户个人信息
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    public ApiResponse getUserInfo(@PathVariable("id") long id){
        UserInfo user = userService.getUser(id);
        if(user != null){
            return ApiResponse.ofSuccess(user);
        }
        return ApiResponse.ofStatus(Status.THIS_USERINFO_NOT_EXITS);
    }
}
