package com.yueyibo.self_study;

public class Abstract {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.calculateTime();

        BB bb = new BB();
        bb.calculateTime();
    }
}

abstract class Template {
    public abstract void job();

    public void calculateTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}


class AA extends Template {
    public void job() {
        long num = 0;
        for (long i = 1; i <= 8000000; i++) {
            num += i;
        }
    }
}


class BB extends Template {
    public void job() {
        long num = 0;
        for (long i = 1; i <= 8000000; i++) {
            num *= i;
        }
    }
}
