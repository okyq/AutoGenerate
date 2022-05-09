package com.example.auto.util;

import com.example.auto.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @ClassName : CreateClass
 * @Description : 创建类
 * @Author : yuqian
 * @Date : 2022/5/6
 */

@Component
public class CreateClass {
    //传入sqlentity用来生成类
    @Autowired
    ClassEntity classEntity;

    //传入lombok注解
    @Autowired
    LombokEntity lombok;

    //传入mybaits注解
    @Autowired
    MybatisEntity mybatisEntity;

    //传入Swagger注解
    @Autowired
    SwaggerEntity swaggerEntity;

    //传入注释note
    @Autowired
    NoteEntity note;


    public String createEntity(){
        classEntity.setAnnoAndNotes(note.createNotes()+lombok.createData()+lombok.createEqualsAndHashCode());
        return classEntity.toString();
    }
}
