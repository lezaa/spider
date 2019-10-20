package com.keepzzz.film.vo;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;



public class LoginVO {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank
    @Length(min=8 , max = 16,message = "密码长度为8到16位")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
