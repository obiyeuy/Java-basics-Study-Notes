package com.yueyibo.self_study.internet.homework.homework03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len  =inputStream.read(b);
        String filename = new String(b,0,len);
        System.out.println("下载文件名是"+filename);
        if(filename.equals("海琴烟")){
            String resFileName = "d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\internet\\homework\\homework03\\海琴烟.jpg";
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(resFileName));
            OutputStream outputStream = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            int readlen = 0;
            while((readlen=bufferedInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,readlen);
            }
            outputStream.close();
            bufferedInputStream.close();
        }else{
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("没有此文件".getBytes());
            outputStream.flush();
            outputStream.close();
        }
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
