package com.yueyibo.self_study.threaduse.thread_method;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        Thread t3 = new Thread(new T3());//创建子线程
        for (int i = 1; i <= 10; i++) {
            System.out.println("hi " + i);
            if(i == 5) {//说明主线程输出了 5 次 hi
                t3.start();//启动子线程 输出 hello...
                t3.join();//立即将 t3 子线程，插入到 main 线程，让 t3 先执行
            }
            Thread.sleep(1000);//输出一次 hi, 让 main 线程也休眠 1s
        }
    }
}

class T3 implements Runnable {
    private int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hello " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}