package com.mdx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试使用
 */
public class BeanTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test.xml");
        Emp emp = applicationContext.getBean(Emp.class);
        System.out.println(emp.getName());
    }

}
