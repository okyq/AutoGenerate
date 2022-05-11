package com.example.auto.sql;

import com.example.auto.entity.TableInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : HandleSqlInfo
 * @Description :
 * @Author : yuqian
 * @Date : 2022/5/11
 */
public class HandleSqlInfo {

    @Autowired
    TableInfos tableInfos;

    @Autowired
    JdbcTemplate jdbcTemplate;

    String dbName = "foticdb";

    //List<Map<String, Object>> show_tables = jdbcTemplate.queryForList("select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_TYPE=\"BASE TABLE\";\n");

    /**
     * @Title: getAllClass
     * @Param: []
     * @Description: 获取所有类名，并存入TableName中的tableName
     * @Author: yuqian
     * @Date: 2022/5/11
     * @Return: java.util.List<java.lang.String>
     * @Throws:
     */
    public String getAllClass(){
        String sql = "SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.TABLES WHERE table_schema="+"'"+ dbName+"'";
        try{
            List<Map<String, Object>> show_tables = jdbcTemplate.queryForList(sql);
            Map<String,String> temp = new HashMap<>();
            for(Map<String , Object> t : show_tables){
                temp.put((String) t.get("TABLE_NAME"), (String) t.get("TABLE_COMMENT"));
            }
            tableInfos.setTableName(temp);
        }
        catch (Exception e){
            return "失败，出现了一些错误：\n"+e;
        }
        return "success";
    }

    public String getAllColumn(){
        String sql1 = "SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.TABLES WHERE table_schema="+"'"+"aa"+"'";
        Map<String , String> map = new HashMap<>();
        map = tableInfos.getTableName();
        for (String s : map.keySet()) {
            String sql =  "SELECT COLUMN_NAME,COLUMN_COMMEN FROM INFORMATION_SCHEMA.Columns WHERE table_name="+"'"+s+"'"+"AND"+"table_schema="+"'"+dbName+"'";
            try{
                List<Map<String, Object>> show_column = jdbcTemplate.queryForList(sql);
                for(Map<String,Object> m : show_column){
                    map.put((String) m.get("COLUMN_NAME"), (String) m.get("COLUMN_COMMEN"));
                }
                tableInfos.setColumns(map);
            }
            catch (Exception e){
                return "fail \n"+e;
            }
        }
        return "success";
    }

}
