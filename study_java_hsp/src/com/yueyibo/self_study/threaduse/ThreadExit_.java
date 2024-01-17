package com.yueyibo.self_study.threaduse;

public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        Test t1 = new Test();
        t1.start();

        //如果希望主线程可以控制t1线程的终止，必须可以修改loop
        //让t1退出run方法，从而终止t1线程 -> 通知方式
        System.out.println("主线程休眠10s...");
        Thread.sleep(10000);
        t1.setLoop(false);
    }
}

@SuppressWarnings({"all"})
class Test extends Thread {
    private int count = 0;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中..." + (++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
