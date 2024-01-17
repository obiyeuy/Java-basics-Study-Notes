package com.yueyibo.self_study.threaduse.ticket;

public class SellTicket {
    public static void main(String[] args) {
//测试
// SellTicket01 sellTicket01 = new SellTicket01();
// SellTicket01 sellTicket02 = new SellTicket01();
// SellTicket01 sellTicket03 = new SellTicket01();
//
// //这里我们会出现超卖.. // sellTicket01.start();//启动售票线程
// sellTicket02.start();//启动售票线程
// sellTicket03.start();//启动售票线程

        System.out.println("===使用实现接口方式来售票=====");
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();//第 1 个线程-窗口
        new Thread(sellTicket02).start();//第 2 个线程-窗口
        new Thread(sellTicket02).start();//第 3 个线程-窗口

    }
}

//使用 Thread 方式
@SuppressWarnings({"all"})
class SellTicket01 extends SellTicket {
    private static int ticketNum = 100;

    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" + "剩余票数=" + (--ticketNum));
        }
    }
}

//实现接口方式
@SuppressWarnings({"all"})
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
