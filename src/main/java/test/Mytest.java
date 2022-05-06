package test;

import com.example.auto.entity.ClassTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName : Mytest
 * @Description :
 * @Author : yuqian
 * @Date : 2022/5/6
 */

public class Mytest {


    ClassTemplate classTemplate = new ClassTemplate();

    @Test
    public void testTemplate(){
        classTemplate.setClassName("Classtest");
        classTemplate.setAuthor("yuqian");
        classTemplate.setDescription("This is  a test");
        classTemplate.setPackageName("com.yq");
        System.out.println(classTemplate.toString());
    }
}
