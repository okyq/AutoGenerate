package com.example.auto.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName : TableName
 * @Description : 用来存储从数据库查询出来的所有信息（测试用）
 * @Author : yuqian
 * @Date : 2022/5/6
 */
@Component
@Data
public class TableInfos {
    private String dbName; //数据库名字
    private Map<String,String> columns; //存字段和注释
    private Map<String,Map<String,String>> tableInfo;  //存表名和字段名 < 表名  <字段名,注释>>
    private Map<String,String> tableName; // 存所有表名和注释

}
