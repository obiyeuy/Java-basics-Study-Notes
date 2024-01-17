package com.yueyibo.self_study.threaduse.homework;

import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}


class A extends Thread {
    private boolean loop = true;

    public void run() {
        while (loop) {
            //打印数字
            System.out.println((int) (Math.random() * 100) + 1);
            //休眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}


class B extends Thread {
    private A a;
    private Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    public void run() {
        while (true) {
            //接收到用户对象输入
            System.out.println("请输入指令表示退出：");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                //以通知的方式结束A线程,且B线程退出
                a.setLoop(false);
                System.out.println("B线程退出");
                break;
            }
        }
    }
}

















