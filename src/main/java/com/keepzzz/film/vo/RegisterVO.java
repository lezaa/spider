package com.keepzzz.film.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

public class RegisterVO extends LoginVO{

    @NotEmpty(message = "姓名不能为空")
    @Length(min = 2)
    private String realName;
    @NotEmpty(message = "身份证号不能为空")
    @Length(min = 18,max = 18)
    private String idCard;
    private String sex;
    @NotEmpty(message = "手机号码不能为空")
    @Length(min = 11,max = 11)
    private String phone;
    private String role;
    private String userPhoto;



    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
}
