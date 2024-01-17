package com.yueyibo.self_study.file.stream.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {

        String filePath = "d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\file\\stream\\bufferedwriter.txt";
        //创建 BufferedWriter
        //说明:
        //1. new FileWriter(filePath, true) 表示以追加的方式写入
        //2. new FileWriter(filePath) , 表示以覆盖的方式写入
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write("hello, yyb!");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        bufferedWriter.write("hello2, yjr!");
        bufferedWriter.newLine();
        bufferedWriter.write("hello3, zpt!");
        bufferedWriter.newLine();
        //说明：关闭外层流即可 ， 传入的 new FileWriter(filePath) ,会在底层关闭
        bufferedWriter.close();
    }
}