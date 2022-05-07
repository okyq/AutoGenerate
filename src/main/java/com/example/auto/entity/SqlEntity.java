package com.example.auto.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName : SqlEntity
 * @Description :
 * @Author : yuqian
 * @Date : 2022/5/6
 */
@Data
@Component
public class SqlEntity {
    private String sqlUrl;
    private String sqlUsername;
    private String sqlPassword;


    private String className;
    private String author;
    private String note;
    private String description;
    private String packageName;

    public String createClass(){
        note = "/**\n" +
                " * @ClassName : "+className+"\n" +
                " * @Description :"+description+"\n" +
                " * @Author : "+author+"\n" +
                " * @Date : "+ LocalDateTime.now().toString().replace("T"," ")+"\n" +
                " */";
        return "package "+packageName+"\n"+
                note+"\n"+
                "public class "+className+" {"+"\n"+
                "}";
    }
}
