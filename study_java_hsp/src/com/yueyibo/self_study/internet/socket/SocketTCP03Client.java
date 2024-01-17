package com.yueyibo.self_study.internet.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//使用字符流
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999 端口, 如果连接成功，返回 Socket 对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 com.yueyibo.self_study.internet.socket 返回=" + socket.getClass());

        //2. 连接上后，生成 Socket, 通过 com.yueyibo.self_study.internet.socket.getOutputStream()
        // 得到 和 com.yueyibo.self_study.internet.socket 对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello server 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();
//        com.yueyibo.self_study.internet.socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //4. IO 读取
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}

