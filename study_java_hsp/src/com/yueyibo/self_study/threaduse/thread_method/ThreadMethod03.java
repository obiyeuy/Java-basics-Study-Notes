package com.yueyibo.self_study.threaduse.thread_method;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonthread dt = new MyDaemonthread();
        //将dt设置成守护线程，当所有线程结束后，dt也自然结束
        //如果没有设置，那么即使main结束，dt仍然在执行
        dt.setDaemon(true);
        dt.start();
        for(int i = 1;i<=100;++i){
            Thread.sleep(50);
            System.out.println("学习......");
        }
    }
}

class MyDaemonthread extends Thread{
    public void run(){
        for(;;){
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("哈哈哈~~~");
        }
    }
}