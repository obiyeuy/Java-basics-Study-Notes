package com.yueyibo.self_study.internet.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//使用字符流
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 在本机 的 9999 端口监听, 等待连接.但是要注意细节
        // 细节: 要求在本机没有其它服务在监听 9999
        // 细节：这个 ServerSocket 可以通过 accept() 返回多个 Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在 9999 端口监听，等待连接..");

        //2. 当没有客户端连接 9999 端口时，程序会阻塞, 等待连接
        // 如果有客户端连接，则会返回 Socket 对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务端 com.yueyibo.self_study.internet.socket =" + socket.getClass());

        //3. 通过 com.yueyibo.self_study.internet.socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //4. IO 读取
        String s = bufferedReader.readLine();
        System.out.println(s);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello client 字符流");
        bufferedWriter.newLine();  //插入一个换行符，表示写入的内容结束
        //注意:要求对方使用readline()！！！否则程序会阻塞
        bufferedWriter.flush();   //如果使用字符流，需要手动刷新，否则数据不会写入数据通道
//        com.yueyibo.self_study.internet.socket.shutdownOutput();  //此时不需要shutdownOutput结束
        //4. 关闭流对象, 必须关闭
        bufferedWriter.close();
        bufferedReader.close();

        socket.close();
        serverSocket.close();//关闭
    }
}
