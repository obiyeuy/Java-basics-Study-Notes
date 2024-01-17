package com.yueyibo.jdbc.transaction_;

import com.yueyibo.jdbc.utils.JDBCUtils_;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 演示 jdbc 中如何使用事务
 */
public class Transaction_ {

    @Test
    //没有使用事务
    public void noTransaction() {
        //1.得到连接
        Connection connection = null;

        //2.组织一个sql语句
        String sql1 = "insert into beauty values(13,'星瞳','女','2004-1-12','13518476467',null,1)";
        String sql2 = "update beauty set boyfriend_id = 1 where id = 5";
        PreparedStatement preparedStatement = null;
        //3.创建PreparedStatement对象
        try {
            connection = JDBCUtils_.getConnection();  // 在默认情况下，connection 是默认自动提交
            preparedStatement = connection.prepareStatement(sql1);
            //执行
            preparedStatement.executeUpdate();
            int i = 1 / 0;  //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第 2 条 sql
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtils_.close(null, preparedStatement, connection);
        }
    }

    //使用事务来解决
    @Test
    public void useTransaction() {
        //操作转账的业务
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个 sql
        String sql1 = "insert into beauty values(13,'星瞳','女','2004-1-12','13518476467',null,1)";
        String sql2 = "update beauty set boyfriend_id = 1 where id = 5";
        PreparedStatement preparedStatement = null;
        //3. 创建 PreparedStatement 对象
        try {
            connection = JDBCUtils_.getConnection(); // 在默认情况下，connection 是默认自动提交
            //将 connection 设置为不自动提交
            connection.setAutoCommit(false); //开启了事务
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate(); // 执行第 1 条 sql
            int i = 1/0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第 3 条 sql
            //这里提交事务
            connection.commit();
        } catch (SQLException e) {
            //这里我们可以进行回滚，即撤销执行的 SQL
            //默认回滚到事务开始的状态.
            System.out.println("执行发生了异常，撤销执行的 sql");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils_.close(null, preparedStatement, connection);
        }
    }
}
