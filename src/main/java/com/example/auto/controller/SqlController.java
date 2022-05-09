package com.example.auto.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.auto.entity.ClassEntity;
import com.example.auto.entity.NoteEntity;

import com.example.auto.entity.TableName;
import com.example.auto.util.CreateClass;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    DruidDataSource druidDataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TableName tableName;

    @Autowired
    NoteEntity note;

    @Autowired
    ClassEntity classEntity;

    @Autowired
    CreateClass createClass;



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
    public String testSql(@RequestParam(value = "sqlIp",required = false)String sqlIp,
                          @RequestParam(value = "sqlPort",required = false)String sqlPort,
                          @RequestParam(value = "sqlUrl",required = false)String sqlUrl,
                          @RequestParam(value = "sqlUsername",required = false)String sqlUsername,
                          @RequestParam(value = "sqlPassword",required = false)String sqlPassword,
                          @RequestParam(value = "packageName",required = false)String packageName,
                          @RequestParam(value = "className",required = false)String className,
                          @RequestParam(value = "author",required = false)String author){
        druidDataSource.setUrl(sqlUrl);
        druidDataSource.setUsername(sqlUsername);
        druidDataSource.setPassword(sqlPassword);
        jdbcTemplate.setDataSource(druidDataSource);
        List<Map<String, Object>> show_tables = jdbcTemplate.queryForList("select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_TYPE=\"BASE TABLE\";\n");
        show_tables.forEach(t->temp.add((String) t.get("TABLE_NAME")));
        tableName.setTableName(temp);
        note.setAuthor(author);
        note.setClassName(className);
        classEntity.setPackageName(packageName);
        System.out.println(createClass.createEntity());

        return "success";
    }

    /**
     *   数据库IP：<input id="sqlIp" type="text" name="sqlIp"><br>
     *     数据库端口号(本地用localhost)：<input id="sqlPort" type="text" name="sqlPort"><br>
     *     自定义数据库URL:<input id="sqlUrl" type="text" name="sqlUrl"><br>
     *     数据库username:<input type="text" name="sqlUsername"><br>
     *     数据库Password:<input type="text" name="sqlPassword"><br>
     *
     *     包名：<input type="text" name="packageName"><br>
     *     类名：<input type="text" name="className"><br>
     *     作者：<input type="text" name="author"><br>
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
