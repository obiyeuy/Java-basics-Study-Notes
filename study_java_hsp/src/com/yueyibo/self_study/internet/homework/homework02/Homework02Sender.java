package com.yueyibo.self_study.internet.homework.homework02;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Homework02Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8889);
        System.out.println("请输入问题:");
        Scanner scanner = new Scanner(System.in);
        String sc = scanner.nextLine();
        byte[] data = sc.getBytes();
        DatagramPacket packet = new DatagramPacket(data,data.length,InetAddress.getByName("10.241.76.106"),8888);
        socket.send(packet);

        byte[] duf = new byte[1024];
        packet = new DatagramPacket(duf,duf.length);
        socket.receive(packet);

        int length = packet.getLength();
        data = packet.getData();
        String s = new String(data,0,length);
        System.out.println(s);
        socket.close();
        System.out.println("发送端退出");
    }
}
