package com.yueyibo.self_study;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey wuKong = new LittleMonkey("悟空");
        wuKong.climbing();
        wuKong.swimming();
        wuKong.flying();
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println(name + "爬树");
    }

    public String getName() {
        return name;
    }
}

interface Fishable {
    void swimming();
}

interface Birdable {
    void flying();
}

class LittleMonkey extends Monkey implements Fishable,Birdable {
    public LittleMonkey(String name) {
        super(name);
    }

    public void swimming() {
        System.out.println(getName() + "通过学习，可以像鱼儿一样游泳...");
    }

    public void flying(){
        System.out.println(getName() + " 通过学习，可以像鸟儿一样飞翔...");
    }
}

