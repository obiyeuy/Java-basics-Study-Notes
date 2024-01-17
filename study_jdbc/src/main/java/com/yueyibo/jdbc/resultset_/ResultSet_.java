package com.yueyibo.jdbc.resultset_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ResultSet_ {
    public static void main(String[] args) throws Exception {
        //通过 Properties 对象获取配置文件的信息
        Properties properties = new Properties();
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
        String sql = "select id ,`name` ,borndate from beauty";
        //执行给定的SQL语句，该语句返回当ResultSet对象
        ResultSet resultSet = statement.executeQuery(sql);

        //5.使用while取出数据
        while(resultSet.next()){  //让光标向后移动，如果没有更多行，则返回false
            int id = resultSet.getInt(1);  //获取该行的第一列
            String name = resultSet.getString(2);
            String borndate = resultSet.getString(3);
            System.out.println(id+"\t"+name+" \t"+borndate);
        }

        //6.关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
