package com.yueyibo.jdbc.utils;

import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils_ {
    //定义相关的属性(4个),因为只需要一份，因此我们做成static
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    //在static代码块初始化
    static{
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\main\\resources\\mysql.properties"));
            //读取相关属性值
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中，我们可以这样处理
            //1. 将编译异常转成 运行异常
            //2. 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便.
            throw new RuntimeException(e);
        }
    }
    //连接数据库，返回一个Connection
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            //1. 将编译异常转成 运行异常
            //2. 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便.
            throw new RuntimeException(e);
        }
    }

    //关闭相关资源
    /**
     * 1.ResultSet  结果集
     * 2.Statement 或者 PreparedStatement
     * 3.Connection
     * 4.如果需要关闭相关资源，就传入对象，否则传入null
     */
    public static void close(ResultSet set, Statement statement, Connection connection){
        //判断是否为null
        try {
            if(set !=null){
                set.close();
            }
            if(statement !=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
