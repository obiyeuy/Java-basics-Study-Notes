package com.yueyibo.jdbc.statement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/**
* 演示 statement 的注入问题
*/
public class Statement_ {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        //让用户输入管理员名与密码
        System.out.println("请输入管理员名字:");  //next():当接收到 空格或者 '就是表示结束
        String admin_name = scanner.nextLine();  //如果希望看到SQL注入，这里需要用nextLine
        System.out.println("请输入管理员密码:");
        String admin_pwd = scanner.nextLine();
//        输入用户名 为 1' or
//        输入万能密码 为 or '1'= '1


        //通过 Properties 对象获取配置文件的信息
        java.util.Properties properties = new Properties();
        properties.load(new FileInputStream("src\\main\\resources\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");


        //1.注册驱动
        Class.forName(driver);//建议写上

        //2.得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //3.得到Statement
        Statement statement = connection.createStatement();

        //4.组织sql语句
        String sql = "select `username`,password from admin where username = '"
                +admin_name+"'and password ='"+admin_pwd+ "'";
        //执行给定的SQL语句，该语句返回当ResultSet对象
        ResultSet resultSet = statement.executeQuery(sql);

        //5.使用while取出数据
        if(resultSet.next()) {  //如果查询到一条记录，则说明该管理存在
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }

        //6.关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
