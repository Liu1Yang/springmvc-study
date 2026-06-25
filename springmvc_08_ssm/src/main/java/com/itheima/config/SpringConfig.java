package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.itheima.service"})   // 扫描 Service 层
@PropertySource("jdbc.properties")     // 加载配置文件
@Import({JdbcConfig.class,MyBatisConfig.class})    // 导入数据源和MyBatis配置
public class SpringConfig {  //  根容器配置（业务层 + 数据层）
}
