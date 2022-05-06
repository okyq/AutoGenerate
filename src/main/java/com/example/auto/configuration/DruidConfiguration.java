package com.example.auto.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName : DruidConfiguration
 * @Description :
 * @Author : yuqian
 * @Date : 2022/5/6
 */
@Lazy
@Configuration
public class DruidConfiguration {
    //先创建bean，放入容器，不配置属性，当接收到前端传来的数据库配置信息的时候再配置属性
    @Bean
    public DruidDataSource SetDruid(){
        return new DruidDataSource();
    }
    @Bean
    public JdbcTemplate getJdbcTemplate(DruidDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
