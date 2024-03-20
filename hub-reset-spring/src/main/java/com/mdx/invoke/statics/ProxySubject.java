package com.mdx.invoke.statics;

/**
 * TODO
 *
 * @Description
 * @Author Administrator
 * @Date 2024/3/20 19:18
 **/
public class ProxySubject implements Subject{
    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void delTask(String taskName) {
        long stime = System.currentTimeMillis();
        subject.delTask(taskName);
        long ftime = System.currentTimeMillis();
        System.out.println("任务耗时"+ (ftime - stime));
    }

}
