package com.yueyibo.self_study.internet.homework.homework01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String question = bufferedReader.readLine();
        String answer = "";
        if (question.equals("name")) {
            answer = "我是nova";
        } else if (question.equals("hobby")) {
            answer = "编写java程序";
        } else {
            answer = "你说啥呢";
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(answer);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
