package com.yueyibo.self_study;

public class HomeWork110 {
    //主方法
    public static void main(String str[]) {
        Test a = new Test();//无参构造器
    }
}

class Sample
{
    Sample(String s)
    {
        System.out.println(s);
    }
    Sample()
    {
        System.out.println("Sample 默认构造函数被调用");
    }
}

class Test{
    Sample sam1=new Sample("sam1 成员初始化");//
    static Sample sam=new Sample("静态成员 sam 初始化 ");//
    static{
        System.out.println("static 块执行");//
        if(sam==null)System.out.println("sam is null");
    }
    Test()//构造器
    {
        System.out.println("Test 默认构造函数被调用");//
    }
}