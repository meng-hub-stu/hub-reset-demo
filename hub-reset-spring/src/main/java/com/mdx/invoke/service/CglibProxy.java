package com.mdx.invoke.service;

import com.mdx.invoke.service.impl.UserServiceImpl01;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author Mengdx
 * @Date 2024/03/09
 **/
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        //设置需要创建的子类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //字节码动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("后置");
        return invoke;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserServiceImpl01 proxy = (UserServiceImpl01) cglibProxy.getProxy(UserServiceImpl01.class);
        proxy.add();
    }



}
