package com.example.auto.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.auto.entity.SqlEntity;

import com.example.auto.entity.TableName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : SqlController
 * @Description :
 * @Author : yuqian
 * @Date : 2022/5/6
 */
@Controller
public class SqlController {

    @Autowired
    SqlEntity sqlEntity;

    @Autowired
    DruidDataSource druidDataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TableName tableName;

    List<String> temp;

    @RequestMapping("/sql")
    @ResponseBody
    public String testSql(SqlEntity sqlEntity){
        druidDataSource.setUrl(sqlEntity.getSqlUrl());
        druidDataSource.setUsername(sqlEntity.getSqlUsername());
        druidDataSource.setPassword(sqlEntity.getSqlPassword());
        jdbcTemplate.setDataSource(druidDataSource);
        List<Map<String, Object>> show_tables = jdbcTemplate.queryForList("show tables");
        for (Map<String,Object> map : show_tables){
            map.forEach((k,v)-> temp.add(v.toString()));
        }
        System.out.println(temp);
        return "success";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
