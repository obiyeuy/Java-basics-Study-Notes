package com.yueyibo.self_study.file.stream.transformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filepath = "d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\file\\stream\\codequestion.txt";
        String charSet = "gbk";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filepath),charSet);
        osw.write("hi,申亚轩！");
        osw.close();
        System.out.println("按照"+charSet+"保存文件成功~");
    }
}
