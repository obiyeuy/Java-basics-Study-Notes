package com.yueyibo.self_study.threaduse.homework;

public class HomeWork02 {
    public static void main(String[] args) {
        QuKuan t = new QuKuan();
        Thread thread1 = new Thread(t);
        thread1.setName("t1");
        Thread thread2 = new Thread(t);
        thread2.setName("t2");
        thread1.start();
        thread2.start();
    }
}

class QuKuan implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            //使用synchronized实现了线程同步
            //当多个线程执行到这里时，就会去争夺this对象锁
            //哪个拿到锁，哪个就执行代码块，执行完后会释放this对象锁
            //争夺不到this对象锁就blocked，准备继续争夺
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足...");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出了1000 当前余额=" + money);
            }
            //休眠 50 毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class SellTicket01 extends Thread {
    private static int ticketNum = 100;//让多个线程共享 ticketNum

    // public void m1() {
    //      synchronized (this) {
    //          System.out.println("hello");
    //      }
    // }
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }
            //休眠 50 毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" + " 剩余票数=" + (--ticketNum));
        }
    }
}

//实现接口方式
class SellTicket02 implements Runnable {
    private int ticketNum = 100;//让多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }
            //休眠 50 毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" + " 剩余票数=" + (--ticketNum));//1 - 0 - -1 - -2
        }
    }
}
