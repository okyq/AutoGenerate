package com.example.auto.entity;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName : TableName
 * @Description :
 * @Author : yuqian
 * @Date : 2022/5/6
 */
@Component
public class TableName {

    private List<String> tableName;

    public List<String> getTableName() {
        return tableName;
    }

    public void setTableName(List<String> tableName) {
        this.tableName = tableName;
    }
}
