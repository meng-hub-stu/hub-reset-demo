package com.mdx.invoke.statics;

/**
 * TODO
 *
 * @Description
 * @Author Administrator
 * @Date 2024/3/20 19:21
 **/
public class SubjectStaticFactory {
    public static Subject getInstance() {
        return new ProxySubject(new RealSubject());
    }

    public static void main(String[] args) {
        Subject proxy = SubjectStaticFactory.getInstance();
        proxy.delTask("删除任务");
    }

}
