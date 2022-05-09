package com.example.auto.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName : ClassTemplate
 * @Description : 一个总的生成class的模板，每个类都有  包名 注释 注解 类{内容}
 * @Author : yuqian
 * @Date : 2022/5/6
 */
@Component
@Data
public class ClassEntity {
    private String packageName;
    private String annoAndNotes;
    private String className;
    private String classContent;

    @Override
    public String toString(){
        return "package "+packageName+"\n"+
                annoAndNotes+"\n"+
                "public class "+className+" {"+"\n"+
                classContent+"\n"+
                "}"+"\n";
    }

}
