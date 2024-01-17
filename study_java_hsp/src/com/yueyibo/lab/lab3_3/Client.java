package com.yueyibo.lab.lab3_3;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("服务器连接成功！");
        System.out.println("选择操作:上传/下载");
        //获取操作
        Scanner scanner = new Scanner(System.in);
        String oper = scanner.nextLine();
        scanner.close();
        //将操作传输给服务端
        OutputStream option = socket.getOutputStream();
        option.write(oper.getBytes());
        option.flush();
        if(oper.equals("上传")){
            String filePath ="d:\\idea\\java_learn\\src\\com.yueyibo.lab\\lab3_2\\test.jpg";
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
            OutputStream outputStream = socket.getOutputStream();

            byte[] bytes = new byte[1024];
            int readlen;
            while ((readlen = bis.read(bytes)) != -1) {
                outputStream.write(bytes, 0, readlen);
            }
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            byte[] b = new byte[512];
            int len = 0;
            len = inputStream.read(b);
            System.out.println(new String(b,0,len));

            //关闭相关流
            inputStream.close();
            outputStream.close();
            bis.close();
            System.out.println("文件操作成功,socket关闭~");
        }else if(oper.equals("下载")){
            String filePath = "d:\\idea\\java_learn\\src\\com.yueyibo.lab\\lab3_2\\test2.jpg";
            InputStream inputStream = socket.getInputStream();
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
            byte[] bytes = new byte[1024];
            int readlen;
            while ((readlen = inputStream.read(bytes)) != -1) {
                bos.write(bytes, 0, readlen);
            }
            System.out.println("文件下载完毕");
            OutputStream hint = socket.getOutputStream();
            hint.write("下载成功".getBytes());
            socket.shutdownOutput();
            hint.close();
            bos.close();
            inputStream.close();
            System.out.println("文件操作成功,socket关闭~");
        }else{
            InputStream inputStream = socket.getInputStream();
            byte[] b = new byte[512];
            int len = 0;
            len = inputStream.read(b);
            System.out.println(new String(b,0,len));
            inputStream.close();
        }
        option.close();
        socket.close();
    }
}













