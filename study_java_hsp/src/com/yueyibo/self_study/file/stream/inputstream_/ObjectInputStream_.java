package com.yueyibo.self_study.file.stream.inputstream_;

import com.yueyibo.self_study.file.stream.outputstream_.Dog;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        String filePath = "d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\file\\stream\\objectstream.dat";
        // 1.创建流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //2.读取， 注意顺序(必须要按照文件中相应对象顺序读取)
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());

        //dog的编译类型是Object，运行类型是Dog
        Object dog = ois.readObject();
        System.out.println("运行类型="+dog.getClass());
        System.out.println(dog);
        //color='null',且没有nation。这是因为序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient修饰的成员

        //这里是特别重要的细节：
        //如果我们希望调用dog的方法，就需要向下转型
        //因此需要我们将Dog类的定义拷贝到可以引用的位置
        Dog dog2 = (Dog)dog;
        System.out.println(dog2.getName());

        //注意：更改对象文件位置后，要先对文件重新进行序列化后再进行反序列化，不然还是会报错

        //3.关闭外层流即可
        ois.close();
        System.out.println("以反序列化的方式读取(恢复)ok~");
    }
}

