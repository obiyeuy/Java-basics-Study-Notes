package com.yueyibo.reflection.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Homework02 {
    public static void main(String[] args) throws Exception {
        Class<?> file = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = file.getDeclaredConstructors();
        for(Constructor c : declaredConstructors) {
            System.out.println("构造器="+c);
        }
        Constructor<?> declaredConstructor = file.getDeclaredConstructor(String.class);
        String filePath = "d:\\idea\\java_learn\\src\\com\\yueyibo\\reflection\\homework\\test.txt";
        Object o = declaredConstructor.newInstance(filePath);
        //o的运行类型就是File
        System.out.println(o.getClass());
        Method createNewFile = file.getMethod("createNewFile");
        createNewFile.invoke(o);
        System.out.println("创建成功");
    }
}
