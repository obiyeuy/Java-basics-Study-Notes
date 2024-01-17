package com.yueyibo.self_study.file.stream.outputstream_;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStream_ {
    public static void main(String[] args) throws Exception {
        //序列化后，保存的文件格式，不是纯文本，而是按照他的格式来保存，所以现在的文件后缀不影响结果
        String filePath = "d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\file\\stream\\objectstream.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        //序列化数据到 d:\idea\java_learn\src\com.yueyibo.self_study\file\stream\objectstream.dat
        oos.writeInt(100);// int -> Integer (实现了 Serializable)
        oos.writeBoolean(true);// boolean -> Boolean (实现了 Serializable)
        oos.writeChar('a');// char -> Character (实现了 Serializable)
        oos.writeDouble(9.5);// double -> Double (实现了 Serializable)
        oos.writeUTF("yyb");//String
        //保存一个 dog 对象
        oos.writeObject(new Dog("旺财", 10, "白色"));
        oos.close();
        System.out.println("数据保存完毕(序列化形式)");
    }
}

