package com.yueyibo.self_study.internet.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//使用字节流
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999 端口, 如果连接成功，返回 Socket 对象
//        System.out.println(InetAddress.getLocalHost());
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 com.yueyibo.self_study.internet.socket 返回=" + socket.getClass());

        //2. 连接上后，生成 Socket, 通过 com.yueyibo.self_study.internet.socket.getOutputStream()
        // 得到 和 com.yueyibo.self_study.internet.socket 对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();

        //3. 通过输出流，写入数据到 数据通道
        outputStream.write("hello, server".getBytes());

        //4. 关闭流对象和 com.yueyibo.self_study.internet.socket, 必须关闭
        outputStream.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
