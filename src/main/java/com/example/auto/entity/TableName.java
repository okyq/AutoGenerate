package com.example.auto.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName : TableName
 * @Description : 用来存储从数据库查询出来的所有表名（测试用）
 * @Author : yuqian
 * @Date : 2022/5/6
 */
@Component
@Data
public class TableName {
    private List<String> tableName;

}
