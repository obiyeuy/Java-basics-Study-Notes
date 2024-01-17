package com.yueyibo.self_study.file.stream.transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//看一个中文乱码问题
public class CodeQuestion {
    public static void main(String[] args) throws IOException {

        //读取 d:\idea\java_learn\src\com.yueyibo.self_study\file\stream\codequestion.txt 文件到程序
        //思路
        //1. 创建字符输入流 BufferedReader [处理流]
        //2. 使用 BufferedReader 对象读取 codequestion.txt
        //3. 默认情况下，读取文件是按照 utf-8 编码
        String filePath = "d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\file\\stream\\codequestion.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String s = br.readLine();
        System.out.println("读取到的内容: " + s);  //会出现乱码，这是因为文件编码不是utf-8
        br.close();
        //InputStreamReader
        //OutputStreamWriter
    }
}
