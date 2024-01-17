package com.yueyibo.lab.lab2_1;

public class Lab2_1 {
    public static void main(String[] args) {
        pay p = new pay(-100,0.15,0.0465);
        p.price = 200;

        p.computePayment(10, 0.25, 0.065);
        System.out.println("三个参数计算得payment=" + p.payment);
        p.computePayment(10, 0.065);
        System.out.println("两个参数计算得payment=" + p.payment);
        p.computePayment(10);
        System.out.println("一个参数计算得payment=" + p.payment);
    }
}
