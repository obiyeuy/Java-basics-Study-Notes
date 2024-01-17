package com.yueyibo.self_study.wrapper;

public class WrapperVSString {
    public static void main(String[] args) {
        //包装类(Integer)->String
        Integer i = 100;//自动装箱
        //方式 1
        String str1 = i + "";
        //方式 2
        String str2 = i.toString();
        //方式 3
        String str3 = String.valueOf(i);
        //String -> 包装类(Integer)
        String str4 = "12345";
        Integer i2 = Integer.parseInt(str4);//使用到自动装箱
        //构造器
        Integer i3 = Integer.valueOf(str4);
        System.out.println("ok~~");
    }
}
