package com.yueyibo;

public class Cat {
    private String name = "招财猫";
    public int age = 10;

    public void hi() {
//        System.out.println("hi" + name);
    }

    public void cry() {
        System.out.println("cry" + name);
    }

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(String name) {
        this.name = name;
    }
}
