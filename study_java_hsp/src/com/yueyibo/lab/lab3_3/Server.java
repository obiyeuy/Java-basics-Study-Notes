package com.yueyibo.lab.lab3_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器已启动，等待连接中...");
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功~");
        //服务端接收操作信息
        InputStream option = socket.getInputStream();
        byte[] b = new byte[512];
        int len = 0;
        len = option.read(b);
        String oper = new String(b, 0, len);
        if (oper.equals("上传")) {
            String filePath = "d:\\idea\\java_learn\\src\\com.yueyibo.lab\\lab3_2\\test1.jpg";
            InputStream inputStream = socket.getInputStream();
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
            byte[] bytes = new byte[1024];
            int readlen;
            while ((readlen = inputStream.read(bytes)) != -1) {
                bos.write(bytes, 0, readlen);
            }
            System.out.println("文件上传完毕");
            //传一个提示给客户端
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("上传成功".getBytes());
            socket.shutdownOutput();
            //关闭相关流
            bos.close();
            inputStream.close();
        } else if (oper.equals("下载")) {
            String filePath = "d:\\idea\\java_learn\\src\\com.yueyibo.lab\\lab3_2\\test1.jpg";
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
            OutputStream outputStream = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            int readlen;
            while ((readlen = bis.read(bytes)) != -1) {
                outputStream.write(bytes, 0, readlen);
            }
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            byte[] buf = new byte[512];
            int length = 0;
            length = inputStream.read(buf);
            System.out.println(new String(buf, 0, length));
            inputStream.close();
            outputStream.close();
            bis.close();
        }else{
            System.out.println("没有此操作,连接断开");
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("没有此操作,连接断开".getBytes());
            socket.shutdownOutput();
            outputStream.close();
        }
        option.close();
        socket.close();
        serverSocket.close();
    }
}
