package com.yueyibo.self_study.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog("小黑", 3));
        list.add(new Dog("大黄", 100));
        list.add(new Dog("大壮", 8));
        //先使用 for 增强
        for (Object dog : list) {
            System.out.println("dog=" + dog);
        }
        //使用迭代器
        System.out.println("===使用迭代器来遍历===");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog = iterator.next();
            System.out.println("dog=" + dog);

        }
    }
}
/**
 * 创建 3 个 Dog {name, age} 对象，放入到 ArrayList 中，赋给 List 引用
 * 用迭代器和增强 for 循环两种方式来遍历
 * 重写 Dog 的 toString 方法， 输出 name 和 age
 */
class Dog {
    private String name;
    private int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
