package com.yueyibo.self_study.file.stream.standard;

public class InputAndOutput {
    public static void main(String[] args) {
        //System.in(源码): public final static InputStream in = null;
        //System.in 编译类型  InputStream
        //System.in 运行类型  class java.io.BufferedInputStream
        System.out.println(System.in.getClass());

        //System.out(源码): public final static PrintStream out = null;
        //System.out 编译类型  PrintStream
        //System.out 运行类型  class java.io.PrintStream
        System.out.println(System.out.getClass());
    }
}
