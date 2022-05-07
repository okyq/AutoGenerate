package com.example.auto.entity;

import org.springframework.stereotype.Component;

/**
 * @ClassName : MybatisEntity
 * @Description : 封装Mybatis注解
 * @Author : yuqian
 * @Date : 2022/5/7
 */

@Component
public class MybatisEntity {

    private String tableName;
    private String tableId;
    private String tableColumn;

    public String createTableName(String tableName){
        return "@TableName(\""+tableName+"\")";
    }

    public String createTableId(String tableId){
        return "@TableId(\""+tableId+"\")";
    }

    public String createTableField(String tableColumn){
        return "@TableField(\""+tableColumn+"\")";
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getTableColumn() {
        return tableColumn;
    }

    public void setTableColumn(String tableColumn) {
        this.tableColumn = tableColumn;
    }
}
