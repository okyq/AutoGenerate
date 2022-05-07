package com.example.auto.entity;

import org.springframework.stereotype.Component;

/**
 * @ClassName : SwaggerEntity
 * @Description : 封装Swagger注解
 * @Author : yuqian
 * @Date : 2022/5/7
 */

@Component
public class SwaggerEntity {

    private String entityValue;
    private String entityDescription;
    private String propertyValue;


    public String createApiModel(String entityValue,String entityDescription){
            return "@ApiModel(value=\""+entityValue+"\", description=\""+entityDescription+"\")";
    }

    public String createApiModelProperty(String propertyValue){
        return "@ApiModelProperty(value = \""+propertyValue+"\")";
    }

    public String getEntityValue() {
        return entityValue;
    }

    public void setEntityValue(String entityValue) {
        this.entityValue = entityValue;
    }

    public String getEntityDescription() {
        return entityDescription;
    }

    public void setEntityDescription(String entityDescription) {
        this.entityDescription = entityDescription;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
