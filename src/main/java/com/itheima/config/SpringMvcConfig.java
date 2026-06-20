package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration是Spring 框架 中的一个注解，用于标记一个类是配置类。
//@Configuration
@ComponentScan("com.itheima.controller")
public class SpringMvcConfig {
}
