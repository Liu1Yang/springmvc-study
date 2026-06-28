package com.itheima.controller;

public class Result {
    private Object data;
    private Integer code;
    private String msg;

    public Result() {
    }

    public Result( Integer code,Object data, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Result( Integer code,Object data) {
        this.data = data;
        this.code = code;
    }

    public Object getData() {
        return data;
    }// Spring MVC 在把对象转成 JSON 发送给 Postman 时，
    // 必须通过 getCode()、getData() 等方法才能把数据读出来。

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
