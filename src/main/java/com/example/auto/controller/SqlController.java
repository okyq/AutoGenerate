package com.example.auto.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.auto.entity.SqlEntity;

import com.example.auto.entity.TableName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

    List<String> temp = new ArrayList<>();

    /**
     * @Title: testSql
     * @Param: [sqlEntity]
     * @Description: 处理前端传来的数据库数据，并设置连接池，把数据库表名放入Bean中，方便后续操作
     * @Author: yuqian
     * @Date: 2022/5/6
     * @Return: java.lang.String
     * @Throws:
     */
    @RequestMapping("/sql")
    @ResponseBody
    public String testSql(SqlEntity sqlEntity){
        druidDataSource.setUrl(sqlEntity.getSqlUrl());
        druidDataSource.setUsername(sqlEntity.getSqlUsername());
        druidDataSource.setPassword(sqlEntity.getSqlPassword());
        jdbcTemplate.setDataSource(druidDataSource);
        List<Map<String, Object>> show_tables = jdbcTemplate.queryForList("select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_TYPE=\"BASE TABLE\";\n");
        show_tables.forEach(t->temp.add((String) t.get("TABLE_NAME")));
        tableName.setTableName(temp);
        System.out.println(sqlEntity.createClass());

        return "success";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
