package test;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.auto.entity.ClassEntity;
import com.example.auto.entity.TableInfos;
import com.example.auto.sql.HandleSqlInfo;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : Mytest
 * @Description :
 * @Author : yuqian
 * @Date : 2022/5/6
 */

public class Mytest {

    @Test
    public void testaa(){
        String url = "jdbc:mysql://139.199.122.96:3306/foticdb?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=Asia/Shanghai";
        String dbName = "foticdb";
        String sql = "SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.TABLES WHERE table_schema="+"'"+dbName+"'";
        System.out.println(sql);
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("foticdba");
        druidDataSource.setPassword("foticadmin");
        druidDataSource.setUrl(url);
        HandleSqlInfo handleSqlInfo = new HandleSqlInfo();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(druidDataSource);
        TableInfos tableInfos = new TableInfos();
        tableInfos.setDbName(dbName);


        String sql1 = "SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.TABLES WHERE table_schema="+"'"+ dbName+"'";
        try{
            List<Map<String, Object>> show_tables = jdbcTemplate.queryForList(sql1);
            Map<String,String> temp = new HashMap<>();
            for(Map<String , Object> t : show_tables){
                temp.put((String) t.get("TABLE_NAME"), (String) t.get("TABLE_COMMENT"));
            }
            tableInfos.setTableName(temp);
        }
        catch (Exception e){
        }

        System.out.println(tableInfos.getTableName());


        Map<String , String> map = new HashMap<>();
        map = tableInfos.getTableName();
        for (String s : map.keySet()) {
            String sql2 =  "SELECT COLUMN_NAME,COLUMN_COMMEN FROM INFORMATION_SCHEMA.Columns WHERE table_name="+"'"+s+"' "+"AND"+" table_schema="+"'"+dbName+"'";
            try{
                List<Map<String, Object>> show_column = jdbcTemplate.queryForList(sql2);
                for(Map<String,Object> m : show_column){
                    map.put((String) m.get("COLUMN_NAME"), (String) m.get("COLUMN_COMMEN"));
                }
                tableInfos.setColumns(map);
            }
            catch (Exception e){
            }
        }
        System.out.println(tableInfos.getColumns());

    }


}
