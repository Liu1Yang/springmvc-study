package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MyBatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean(); // 创建 MyBatis 的核心工厂，设置数据源和实体类包路径（用于自动别名）。
        factoryBean.setDataSource(dataSource);  // 注入数据源
        factoryBean.setTypeAliasesPackage("com.itheima.domain"); // 实体类别名
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){  // 扫描 dao 包下的所有 Mapper 接口
        // ，动态生成代理对象并注册到 Spring 容器，这样 Service 里就可以直接 @Autowired 那些 Mapper 接口了。
        MapperScannerConfigurer msc=new MapperScannerConfigurer();
        msc.setBasePackage("com.itheima.dao");   // 扫描 Mapper 接口
        return msc;
    }

}
