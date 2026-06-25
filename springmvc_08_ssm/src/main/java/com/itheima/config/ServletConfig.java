package com.itheima.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
// Web 应用启动入口,完全替代传统的 web.xml，是 SpringMVC 零配置启动的核心。

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { // 创建子容器（DispatcherServlet），只负责 Controller。
        return new Class[]{SpringMvcConfig.class};   // 父子容器关系：子容器（MVC）可以访问父容器（Service/Dao）的 Bean，
        // 但父容器不能访问子容器的 Bean。所以 Controller 里可以 @Autowired Service，但 Service 里不能 @Autowired Controller。
    }

    @Override
    protected String[] getServletMappings() {  // 创建父容器（ContextLoaderListener），负责 Service、Dao、数据源等。
        return new String[]{"/"};
    }
}
