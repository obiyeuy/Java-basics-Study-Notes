package com.yueyibo.self_study.file.printstream;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        //在默认情况下，PrintStream输出数据的位置是 标准输出，即显示器
        out.print("hello,john!");
        //因为print底层使用的是write方法，所以我们可以直接调用write进行打印/输出
        out.write("小艾，你好！".getBytes());
        out.close();

        //我们可以去修改打印流输出的位置/设备
        //输出修改成d:\idea\java_learn\src\com.yueyibo.self_study\file\stream\printstream.txt
        System.setOut(new PrintStream("d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\file\\printstream\\printstream.txt"));
        System.out.println("hello,小杜.");
    }
}
