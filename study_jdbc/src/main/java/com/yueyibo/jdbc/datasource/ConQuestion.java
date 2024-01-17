package com.yueyibo.jdbc.datasource;

import com.yueyibo.jdbc.utils.JDBCUtils_;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConQuestion {
    //代码 连接 mysql 5000 次
    @Test
    public void testCon() {
        //看看传统连接-关闭 connection 会耗用多久
        long start = System.currentTimeMillis();
        System.out.println("开始连接.....");
        for (int i = 0; i < 5000; i++) {
            //使用传统的 jdbc 方式，得到连接
            Connection connection = JDBCUtils_.getConnection();  //不关闭的话会抛出 Too many connections异常
            //做一些工作，比如得到 PreparedStatement ，发送 sql
            //..........
            //关闭
            JDBCUtils_.close(null, null, connection);
        } //耗时长
        long end = System.currentTimeMillis();
        System.out.println("传统方式 5000 次 耗时=" + (end - start));//传统方式 5000 次 耗时=111437
    }
}
