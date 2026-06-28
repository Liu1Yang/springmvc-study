package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.itheima.service"})   // 扫描 Service 层
@PropertySource("classpath:jdbc.properties")     //debug:没有加classpath:Tomcat跑去  根目录下面找jdbc.properties 文件自然找不到了
@Import({JdbcConfig.class,MyBatisConfig.class})    // 导入数据源和MyBatis配置
@EnableTransactionManagement // 这个注解是开启 Spring 声明式事务 的关键！
// 如果不加，你以后在 Service 层的 insert、update、delete 方法上即使写了 @Transactional 也是无效的，发生异常时数据不会自动回滚。
public class SpringConfig {  //  根容器配置（业务层 + 数据层）
}
