package com.mdx.invoke.service;


import com.mdx.invoke.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Mengdx
 * @Date 2024/03/09
 **/
public class JdkProxy implements InvocationHandler {

    private Object target;
    public JdkProxy(Object target) {
        super();
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象方法前-----");
        Object invoke = method.invoke(target, args);
        System.out.println("代理对象方法后----");
        return invoke;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        JdkProxy handler = new JdkProxy(userService);
        UserService proxy = (UserService)handler.getProxy();
        proxy.add();
    }




}
