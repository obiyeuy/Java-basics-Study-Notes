package com.yueyibo.self_study.threaduse.thread_method;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        //测试join的使用
        T t1 = new T();
        t1.start();

        //说明：
        //1.让jd插队到主线程前面，这样main就会等jd执行完毕，再执行
        //2.如果没有join，那么JoinThread和Main线程就会交替执行
        t1.join();
        for(int i =1;i<=20;++i){
            Thread.sleep(50);
            System.out.println("张三丰"+i);
        }
    }
}


class T extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 20; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("JoinThread------" + i);
            }
        }
    }
}