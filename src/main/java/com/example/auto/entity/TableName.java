package com.example.auto.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName : TableName
 * @Description :
 * @Author : yuqian
 * @Date : 2022/5/6
 */
@Component
@Data
public class TableName {
    private List<String> tableName;

}
