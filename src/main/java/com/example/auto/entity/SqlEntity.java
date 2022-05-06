package com.example.auto.entity;

import org.springframework.stereotype.Component;

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

    @Override
    public String toString() {
        return "SqlEntity{" +
                "sqlUrl='" + sqlUrl + '\'' +
                ", sqlUsername='" + sqlUsername + '\'' +
                ", sqlPassword='" + sqlPassword + '\'' +
                '}';
    }
}
