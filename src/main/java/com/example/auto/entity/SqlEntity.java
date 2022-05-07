package com.example.auto.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName : SqlEntity
 * @Description :
 * @Author : yuqian
 * @Date : 2022/5/6
 */

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

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public String getSqlUrl() {
        return sqlUrl;
    }

    public void setSqlUrl(String sqlUrl) {
        this.sqlUrl = sqlUrl;
    }

    public String getSqlUsername() {
        return sqlUsername;
    }

    public void setSqlUsername(String sqlUsername) {
        this.sqlUsername = sqlUsername;
    }

    public String getSqlPassword() {
        return sqlPassword;
    }

    public void setSqlPassword(String sqlPassword) {
        this.sqlPassword = sqlPassword;
    }

}
