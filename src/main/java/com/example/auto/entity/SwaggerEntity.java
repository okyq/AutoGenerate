package com.example.auto.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName : SwaggerEntity
 * @Description : 封装Swagger注解
 * @Author : yuqian
 * @Date : 2022/5/7
 */

@Component
@Data
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


}
