package com.example.auto.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @ClassName : ClassTemplate
 * @Description :
 * @Author : yuqian
 * @Date : 2022/5/6
 */
@Component
@Data
public class ClassTemplate {
    private String packageName;
    private String className;
    private String description;
    private String author;
    private String note = "/**\n" +
            " * @ClassName : "+className+"\n" +
            " * @Description :"+description+"\n" +
            " * @Author : "+author+"\n" +
            " * @Date : "+ LocalDateTime.now()+"\n" +
            " */";
    private String publicClass = "public class"+className;

    @Override
    public String toString(){
        return "package "+packageName+"\n"+
                note+"\n"+
                "public class "+className+" {"+"\n"+
                "}";
    }

}
