package com.yueyibo.reflection.homework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Homework01 {
    public static void main(String[] args) throws Exception {
        Class<privateTest> cls = privateTest.class;
        privateTest o = cls.getDeclaredConstructor().newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "yyb");
        Method getName = cls.getMethod("getName");
        Object invoke = getName.invoke(o);
        System.out.println("name=" + invoke);
    }
}


class privateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "privateTest{" +
                "name='" + name + '\'' +
                '}';
    }
}