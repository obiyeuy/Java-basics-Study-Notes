package com.yueyibo.jdbc.statement_;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 预处理好处
 * 1.不再使用+破解sql语句，减少语法错误
 * 2.有效的解决了sql注入问题
 * 3.大大减少了编译次数，效率较高
 */
public class PreparedStatementDML_ {
    public static void main(String[] args) throws Exception {
        //演示使用，看能否解决sql注入问题

        Scanner scanner = new Scanner(System.in);

        //让用户输入管理员名与密码
        System.out.println("请输入管理员名字:");
        String admin_name = scanner.nextLine();
        System.out.println("请输入管理员密码:");
        String admin_pwd = scanner.nextLine();
        //输入用户名 为 1' or;输入万能密码 为 or '1'= '1  就不会有用

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


        //3.得到 PreparedStatement
        //3.1 组织sql  sql语句的?就相当于占位符
        //添加记录
        //String sql = "insert into admin values(?,?,?)";

        //修改记录
        //String sql = "update admin set password = ? where id = ?";

        //删除记录
        String sql = "delete from admin where id = ?";


        //3.2 preparedStatement 对象实现了PreparedStatement接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3 给?赋值
        //添加记录
//        preparedStatement.setInt(1,3);
//        preparedStatement.setString(2,admin_name);
//        preparedStatement.setString(3,admin_pwd);

        //修改记录
//        preparedStatement.setString(1,admin_pwd);
//        preparedStatement.setInt(2,3);

        //删除记录
        preparedStatement.setInt(1,3);


        //4.执行delete，insert，upsate 语句使用 executeUpdate()
        //这里执行 executeQuery() ,不要再写sql  否则占位符还存在，语句不正确
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows>0?"执行成功":"执行失败");

        //5.关闭连接
        preparedStatement.close();
        connection.close();
    }
}

