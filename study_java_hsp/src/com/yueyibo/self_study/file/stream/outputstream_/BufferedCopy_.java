package com.yueyibo.self_study.file.stream.outputstream_;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//使用他们，可以完成二进制文件拷贝.
//思考：字节流可以操作二进制文件，可以操作文本文件吗？当然可以
//但是字符流最好不要操作二进制文件，可能会损坏文件
public class BufferedCopy_ {
    public static void main(String[] args) {
        String srcFilePath = "d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\file\\stream\\socketcopy.jpg";
        String destFilePath = "d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\file\\stream\\filecopy2.jpg";

        //创建 BufferedOutputStream 对象 BufferedInputStream 对象
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //因为 FileInputStream 是 InputStream 子类
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

            //循环的读取文件，并写入到 destFilePath
            byte[] buff = new byte[1024];
            int readLen = 0;

            //当返回 -1 时，就表示文件读取完毕
            while ((readLen = bis.read(buff)) != -1) {
                bos.write(buff, 0, readLen);
            }
            System.out.println("文件拷贝完毕~~~");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流 , 关闭外层的处理流即可，底层会去关闭节点流
            try {
                if(bis != null) {
                    bis.close();
                }
                if(bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
