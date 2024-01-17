package com.yueyibo.self_study.threaduse;

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start(); 这里不能调用 start

        //创建了 Thread 对象，把 dog 对象(实现 Runnable),放入 Thread
        Thread thread = new Thread(dog);
        thread.start();
        // Tiger tiger = new Tiger();//实现了 Runnable
        // ThreadProxy threadProxy = new ThreadProxy(tiger);
        // threadProxy.start();
    }
}
class Animal {
}
class Tiger extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫....");
    }
}

//线程代理类 , 模拟了一个极简的 Thread 类
class ThreadProxy implements Runnable {//你可以把 Proxy 类当做 ThreadProxy
    private Runnable target = null;//属性，类型是 Runnable
    @Override
    public void run() {
        if (target != null) {
            target.run();//动态绑定（运行类型 Tiger）
        }
    }
    public ThreadProxy(Runnable target) {
        this.target = target;
    }
    public void start() {
        start0();//这个方法时真正实现多线程方法
    }
    public void start0() {
        run();
    }
}
@SuppressWarnings({"all"})
class Dog implements Runnable { //通过实现 Runnable 接口，开发线程
    int count = 0;
    @Override
    public void run() { //普通方法
        while (true) {
            System.out.println("小狗汪汪叫..hi" + (++count) + Thread.currentThread().getName());
            //休眠 1 秒
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
