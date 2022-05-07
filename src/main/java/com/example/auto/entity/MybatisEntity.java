package com.example.auto.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName : MybatisEntity
 * @Description : 封装Mybatis注解
 * @Author : yuqian
 * @Date : 2022/5/7
 */

@Data
@Component
public class MybatisEntity {

    private String tableName;
    private String tableId;
    private String tableColumn;


}
