package com.yueyibo.self_study.internet.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999 端口, 如果连接成功，返回 Socket 对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 com.yueyibo.self_study.internet.socket 返回=" + socket.getClass());

        //2. 连接上后，生成 Socket, 通过 com.yueyibo.self_study.internet.socket.getOutputStream()
        // 得到 和 com.yueyibo.self_study.internet.socket 对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();

        //3. 通过输出流，写入数据到 数据通道
        outputStream.write("hello, server".getBytes());
        //4. 加上结束标记!!! 必须加，不然会一直等待
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));//根据读取到的实际长度，显示内容.
        }

        outputStream.close();
        inputStream.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}

