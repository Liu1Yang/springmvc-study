package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.itheima.controller","com.itheima.config"})  // 只扫描 Controller 层。
@EnableWebMvc  //开启 SpringMVC 注解支持（相当于 <mvc:annotation-driven>），
// 会自动注册 RequestMappingHandlerMapping 和 RequestMappingHandlerAdapter，并启用 JSON 转换、类型转换等。
public class SpringMvcConfig {  // MVC 容器配置（表现层）
}
