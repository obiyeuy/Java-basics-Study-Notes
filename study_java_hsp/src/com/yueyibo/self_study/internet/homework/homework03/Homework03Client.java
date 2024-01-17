package com.yueyibo.self_study.internet.homework.homework03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Homework03Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("输入文件名:");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        scanner.close();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(filename.getBytes());
        outputStream.flush();
        if (filename.equals("海琴烟")) {
            String filePath = "d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\internet\\homework\\homework03\\海琴烟copy.jpg";
            InputStream inputStream = socket.getInputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            byte[] bytes = new byte[1024];
            int readlen = 0;
            while((readlen = inputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,readlen);
            }
            bufferedOutputStream.flush();
            inputStream.close();
            bufferedOutputStream.close();
        } else {
            InputStream inputStream = socket.getInputStream();
            byte[] b = new byte[1024];
            int len  =inputStream.read(b);
            System.out.println(new String(b, 0, len));
            inputStream.close();
        }
        outputStream.close();
        socket.close();
    }
}












