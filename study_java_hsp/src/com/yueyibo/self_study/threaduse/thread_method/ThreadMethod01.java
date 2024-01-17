package com.yueyibo.self_study.threaduse.thread_method;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo01 t = new ThreadDemo01();
        t.setName("小笼包");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
        //测试优先级
        System.out.println("默认优先级为" + Thread.currentThread().getPriority());
        Thread.sleep(3000);
        //测试interrupt
        t.interrupt();
    }
}

class ThreadDemo01 extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
        try {
            System.out.println(Thread.currentThread().getName() + "休眠中...");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断了");
        }
    }
}
