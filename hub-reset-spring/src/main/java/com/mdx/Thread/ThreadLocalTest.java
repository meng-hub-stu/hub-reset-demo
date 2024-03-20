package com.mdx.Thread;

//import jdk.internal.misc.TerminatingThreadLocal;

/**
 * TODO
 *
 * @Description
 * @Author Administrator
 * @Date 2024/3/16 20:21
 **/
public class ThreadLocalTest {

    public static void main(String[] args) {
        //子类不可以调用
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        //线程池子类使用
//        ThreadLocal<String> terminatingThreadLocal = new TerminatingThreadLocal<>();
        //子类可以调用
        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        threadLocal.set("父类数据:threadLocal");
        inheritableThreadLocal.set("父类数据:inheritableThreadLocal");
//        terminatingThreadLocal.set("父类数据:terminatingThreadLocal");

        new Thread(() -> {
            System.out.println("子线程获取父类threadLocal数据：" + threadLocal.get());
            System.out.println("子线程获取父类inheritableThreadLocal数据：" +inheritableThreadLocal.get());
//            System.out.println("子线程获取父类terminatingThreadLocal数据：" + terminatingThreadLocal.get());
        }).start();

    }
}
