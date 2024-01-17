package com.yueyibo.lab.lab2_1;


public class pay {
    double price;
    double withhold_rate = 0.15;
    double pay_rate = 0.0465;
    double payment;

    public pay() {
    }

    public pay(double price, double pay_rate, double withhold_rate) {
        setPrice(price);
        this.withhold_rate = withhold_rate;
        this.pay_rate = pay_rate;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("价格应该是个正数吧~程序猿已经将其置为默认值0~");
            this.price = 0;
        }
    }

    public void computePayment(int hours, double withhold_rate, double pay_rate) {
        this.payment = hours * price * (1 - withhold_rate) * (1 - pay_rate);
    }

    public void computePayment(int hours, double pay_rate) {
        this.payment = hours * price * (1 - 0.15) * (1 - pay_rate);
    }

    public void computePayment(int hours) {
        this.payment = hours * price * (1 - 0.15) * (1 - 0.0465);
    }
}

