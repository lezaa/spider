package com.keepzzz.film.enums;

public enum Status {

    SUCCESS(200,"成功"),
    BAD_REQUEST(400,"请求错误"),
    INTERNAL_SERVER_ERROR(500,"服务器错误"),
    NOT_VALID_PARAM(40005,"参数验证错误"),
    Not_SUPPORTED_OPERATION(40006,"不被支持的操作"),
    NOT_LOGIN(50000,"未登录"),
    ACCOUNT_ERROR(60000,"账号或者密码错误"),
    THIS_USERINFO_NOT_EXITS(40004,"用户信息不存在"),
    THIS_USER_ALREADY_PUBLISH_COMMENT(30001,"你已经评论过了");

    private int code;
    private String standardMessage;


    Status(int code,String standardMessage){
        this.code = code;
        this.standardMessage = standardMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStandardMessage() {
        return standardMessage;
    }

    public void setStandardMessage(String standardMessage) {
        this.standardMessage = standardMessage;
    }
}
