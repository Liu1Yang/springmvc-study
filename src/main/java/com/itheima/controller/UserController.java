package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/save")
    @ResponseBody // 设置当前控制器方法响应内容为当前返回值，无需解析 查找对应页面
    // @RestController 简化写法
    //@RestController = @Controller + @ResponseBody
    //如果类上加 @RestController，所有方法默认都会把返回值作为响应体，无需每个方法单独写 @ResponseBody。
    public String save(){
        System.out.println("user save...");
        return "{\"info\":\"springmvc\"}";
        //return "{'info':'springmvc'}";  标准 JSON 要求使用双引号，单引号不符合规范，
    }
}
