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
    @Bean
    public DruidDataSource SetDruid(){
        return new DruidDataSource();
    }
    @Bean
    public JdbcTemplate getJdbcTemplate(DruidDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
