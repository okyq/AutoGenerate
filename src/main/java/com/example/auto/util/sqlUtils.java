package com.example.auto.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName : sqlUtils
 * @Description : 处理sql信息
 * @Author : yuqian
 * @Date : 2022/5/9
 */
public class sqlUtils {

    @Autowired
    JdbcTemplate jdbcTemplate;


}
