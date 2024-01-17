package com.yueyibo.self_study.exception;

public class CustomException {
    public static void main(String[] args) {
        int age = 180;
        if(!(age>=18&&age<=120)){
            throw new AgeException("年龄需在18~120之间");
        }
        System.out.println("你的年龄范围正确");
    }
}

//自定义一个异常
//1. 一般情况下，我们自定义异常是继承 RuntimeException
//2. 即把自定义异常做成 运行时异常，好处时，我们可以使用默认的处理机制
//3. 即比较方便

class AgeException extends RuntimeException{
    public AgeException(String message){
        super(message);
    }
}