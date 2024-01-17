package com.yueyibo.jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 该类演示如何使用 JDBCUtils 工具类，完成 dml 和 select
 */
public class JDBCUtils_Use {
    @Test
    public void testDML(){
        //1.得到连接
        Connection connection = JDBCUtils_.getConnection();

        //2.组织一个sql语句
        String sql = "update boys set boyName = ? where id = ?";
        PreparedStatement preparedStatement = null;
        //3.创建PreparedStatement对象
        try {
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1,"小岳");
            preparedStatement.setInt(2,1);
            //执行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            //关闭资源
            JDBCUtils_.close(null,preparedStatement,connection);
        }
    }
}
