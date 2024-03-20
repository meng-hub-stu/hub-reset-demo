package com.mdx.invoke.statics;

/**
 * TODO
 *
 * @Description
 * @Author Administrator
 * @Date 2024/3/20 19:16
 **/
public class RealSubject implements Subject{

    @Override
    public void delTask(String taskName) {
        try {
            Thread.sleep(2000);
            System.out.println("正在执行任务" + taskName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
