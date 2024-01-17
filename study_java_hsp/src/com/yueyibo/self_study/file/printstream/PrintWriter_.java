package com.yueyibo.self_study.file.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        //输出到显示屏
        //PrintWriter printWriter = new PrintWriter(System.out);

        //下面将数据保存到文件中
        PrintWriter printWriter = new PrintWriter(new FileWriter("d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\file\\printstream\\printstream.txt"));
        printWriter.print("hi,北京你好~");

        //注意必须要关闭文件，关闭或刷新时才会将流中数据保存，否则不会保存，丢失数据
        printWriter.close();
        System.out.println("输入成功~");
    }
}
