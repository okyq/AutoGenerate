package com.example.auto.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @ClassName : NoteEntity
 * @Description : 用来生成类上的注释
 * @Author : yuqian
 * @Date : 2022/5/9
 */
@Data
@Component
public class NoteEntity {
    private String className;
    private String description;
    private String author;
    private String date;

    public String createNotes(){
        return "/**\n" +
                " * @ClassName : "+className+"\n" +
                " * @Description :"+description+"\n" +
                " * @Author : "+author+"\n" +
                " * @Date : "+ LocalDateTime.now().toString().replace("T"," ")+"\n" +
                " */"+"\n";
    }
}
