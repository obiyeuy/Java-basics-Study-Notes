package com.yueyibo.reflection.class_;

import com.yueyibo.Car;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllPath = "com.yueyibo.Car";
        //获取到Car类对应的Class对象
        //<?>表示不确定的Java类型
        Class<?> cls = Class.forName(classAllPath);
        //输出cls
        System.out.println(cls);  //显示cla对象，是哪个类的Class对象  com.yueyibo.Car
        System.out.println(cls.getClass());  //输出cls运行类型  java.lang.Class
        //得到包名
        System.out.println(cls.getPackage().getName());  //包名
        //得到类名
        System.out.println(cls.getName());
        //通过cls创建对象实例
        Car car = (Car) cls.getDeclaredConstructor().newInstance();
        System.out.println(car);  //car.toString();
        //通过反射获取属性brand
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));
        //通过反射给属性赋值
        brand.set(car,"奔驰");
        System.out.println(brand.get(car));
        //得到所有的属性
        Field[] fields = cls.getFields();
        for(Field f:fields){
            System.out.println(f.getName());
        }
    }
}
