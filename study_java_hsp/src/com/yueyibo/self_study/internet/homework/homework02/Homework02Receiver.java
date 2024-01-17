package com.yueyibo.self_study.internet.homework.homework02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Homework02Receiver {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] duf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(duf,duf.length);
        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data,0,length);

        String answer = "" ;
        if(s.equals("四大名著是哪些")){
            answer = "西游记，红楼梦，三国演义，水浒传";
        }else{
            answer = "what";
        }
        data = answer.getBytes();
        packet = new DatagramPacket(data,data.length,InetAddress.getByName("10.241.76.106"),8889);
        socket.send(packet);

        socket.close();
        System.out.println("接收端退出");
    }
}
