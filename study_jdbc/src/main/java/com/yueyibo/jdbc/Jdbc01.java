package com.yueyibo.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        Driver driver = new Driver();

        //2.得到连接
        // 解读
        //(1) jdbc:mysql:// 规定好表示协议，通过 jdbc 的方式连接 mysql
        //(2) localhost 主机，可以是 ip 地址
        //(3) 3306 表示 mysql 监听的端口
        //(4) hsp_db02 连接到 mysql dbms 的哪个数据库
        //(5) mysql 的连接本质就是前面学过的 socket 连接
        String url = "jdbc:mysql://localhost:3306/girls";
        //将用户名与密码放到Properties文件
        Properties properties = new Properties();

        properties.setProperty("user", "root");
        properties.setProperty("password", "20031224yyb");
        Connection connect = driver.connect(url, properties);

        //3.执行sql
//        String sql = "insert into beauty values(13,'星瞳','女','2004-01-12','13519476467',null,10)";
//        String sql = "update boys set boyName='小岳' where id= 2";
        String sql = "delete from boys where id = 3";
//        statement用于执行静态SQL语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int row = statement.executeUpdate(sql);

        System.out.println(row > 0 ? "成功" : "失败");

        //4.关闭连接资源
        statement.close();
        connect.close();
    }
}













