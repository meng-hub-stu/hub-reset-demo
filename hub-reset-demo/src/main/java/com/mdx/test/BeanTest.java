package com.mdx.test;

import com.mdx.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试使用
 */
public class BeanTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test.xml");
        User user = applicationContext.getBean(User.class);
        System.out.println(user.getName());
    }

}
