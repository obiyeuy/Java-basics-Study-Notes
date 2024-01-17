package com.yueyibo.self_study.file.properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Properties01 {
    public static void main(String[] args) throws IOException {
        //读取 mysql.properties 文件，并得到 ip, user 和 pwd
        BufferedReader br = new BufferedReader(new FileReader("d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\file\\properties_\\mysql.properties"));
        String line = "";
        while ((line = br.readLine()) != null) { //循环读取
            String[] split = line.split("=");
            //如果我们要求指定的 ip 值
            if ("ip".equals(split[0])) {
                System.out.println(split[0] + "值是: " + split[1]);
            }
        }
        br.close();
    }
}
