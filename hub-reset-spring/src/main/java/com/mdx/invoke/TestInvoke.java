package com.mdx.invoke;

import java.lang.reflect.Method;

/**
 * @Author Mengdx
 * @Date 2024/03/09
 **/
public class TestInvoke {

    public void foo(String name) {
        System.out.println("测试foo方法" + name);
    }


    public static void main(String[] args) throws Exception {
        Class<?> aClass = TestInvoke.class;
        Method foo = aClass.getMethod("foo", String.class);
        foo.invoke(aClass.newInstance(), "你好");
    }

}
