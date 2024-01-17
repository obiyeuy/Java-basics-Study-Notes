package com.yueyibo.self_study.internet.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        String filePath ="d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\internet\\socket\\socketcopy.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        //bytes就是filePath对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bis.close();
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        String s =StreamUtils.streamToString(inputStream);
        System.out.println(s);

        //关闭相关流
        inputStream.close();
        bos.close();
        socket.close();
    }
}













