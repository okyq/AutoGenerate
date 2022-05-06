package com.example.auto.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @ClassName : ClassTemplate
 * @Description :
 * @Author : yuqian
 * @Date : 2022/5/6
 */
@Component
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

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPublicClass() {
        return publicClass;
    }

    public void setPublicClass(String publicClass) {
        this.publicClass = publicClass;
    }
}
