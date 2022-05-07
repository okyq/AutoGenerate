package com.example.auto.entity;

import org.springframework.stereotype.Component;

/**
 * @ClassName : LombokEntity
 * @Description : 封装Lombok注解
 * @Author : yuqian
 * @Date : 2022/5/7
 */

@Component
public class LombokEntity {

    public String createData(){
        return "@Data";
    }
    public String createEqualsAndHashCode(){
        return "@EqualsAndHashCode(callSuper = false)";
    }
}
