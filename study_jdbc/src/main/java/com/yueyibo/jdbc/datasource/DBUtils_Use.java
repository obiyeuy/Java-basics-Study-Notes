package com.yueyibo.jdbc.datasource;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtils_Use {
    @Test
    //使用 apache-DBUtils 工具类 + druid 完成对表的 crud 操作
    public void testQueryMany() throws SQLException {
        //1.得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用DBUtils类和接口，先引入jar包
        //3.创建一个QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.就可以执行相关方法，返回ArrayList结果集
        String sql = "select * from beauty where id >= ?";

        // 解读
        //(1) query 方法就是执行 sql 语句，得到 resultset ---封装到 --> ArrayList 集合中
        //(2) 返回集合
        //(3) connection: 连接
        //(4) sql : 执行的 sql 语句
        //(5) new BeanListHandler<>(Actor.class): 在将 resultset -> Actor 对象 -> 封装到 ArrayList
        // 底层使用反射机制 去获取 Actor 类的属性，然后进行封装
        //(6) 1 就是给 sql 语句中的? 赋值，可以有多个值，因为是可变参数 Object... params

        List<Beauty> list = queryRunner.query(connection, sql, new BeanListHandler<Beauty>(Beauty.class), 1);

        //(7) 底层得到的 resultset ,会在 query 关闭, 关闭 PreparedStatment
        /*
         分析 queryRunner.query 方法:
         public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
            PreparedStatement stmt = null;//定义 PreparedStatement
            ResultSet rs = null;//接收返回的 ResultSet
            Object result = null;//返回 ArrayList

            try {
                stmt = this.prepareStatement(conn, sql);//创建 PreparedStatement
                this.fillStatement(stmt, params);//对 sql 进行 ? 赋值
                rs = this.wrap(stmt.executeQuery());//执行 sql,返回 resultset
                result = rsh.handle(rs); //返回的 resultset --> arrayList[result]  [使用到反射，对传入 class 对象处理]
            } catch (SQLException var33) {
                this.rethrow(var33, sql, params);
            } finally {
                try {
                    this.close(rs);//关闭 resultset
                } finally {
                    this.close((Statement)stmt);//关闭 preparedstatement 对象
                }
            }
            return result;
         }
         */

        System.out.println("输出集合的信息:");
        for (Beauty beauty : list) {
            System.out.println(beauty);
        }
        //释放资源    底层得到的 resultset ,会在 query 关闭, 也会关闭 PreparedStatment
        JDBCUtilsByDruid.close(null, null, connection);
    }


    //演示 apache-dbutils + druid 完成 返回的结果是单行记录(单个对象)
    @Test
    public void testQuerySingle() throws SQLException{
        //1.得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用DBUtils类和接口，先引入jar包
        //3.创建一个QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.就可以执行相关方法，返回单个对象
        String sql = "select * from beauty where id = ?";
        // 解读
        // 因为我们返回的单行记录<--->单个对象 , 使用的 Hander 是 BeanHandler
        Beauty beauty = queryRunner.query(connection, sql, new BeanHandler<>(Beauty.class), 6);
        System.out.println(beauty);
        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }

    //演示 apache-dbutils + druid 完成查询结果是单行单列-返回的就是 object
    @Test
    public void testScalar() throws SQLException {
        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入 DBUtils 相关的 jar , 加入到本 Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关的方法，返回单行单列 , 返回的就是 Object
        String sql = "select name from beauty where id = ?";
        //解读： 因为返回的是一个对象, 使用的 handler 就是 ScalarHandler
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 4);
        System.out.println(obj);
        // 释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示 apache-dbutils + druid 完成 dml (update, insert ,delete)
    @Test
    public void testDML() throws SQLException {
        //1. 得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入 DBUtils 相关的 jar , 加入到本 Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 这里组织 sql 完成 update, insert delete
        //String sql = "update beauty set name = ? where id = ?";
        //String sql = "insert into beauty values(null, ?, ?, ?, ?, ?,null, ?)";
        String sql = "delete from beauty where id = ?";
        //解读
        //(1) 执行 dml 操作是 queryRunner.update()
        //(2) 返回的值是受影响的行数 (affected: 受影响)
        //int affectedRow = queryRunner.update(connection, sql, "月", 4);
        //int affectedRow = queryRunner.update(connection, sql, "林青霞", "女", "1966-10-10", "1415425672576",null,1);
        int affectedRow = queryRunner.update(connection, sql, 1000 );
        System.out.println(affectedRow > 0 ? "执行成功" : "执行没有影响到表");
        // 释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }
}
