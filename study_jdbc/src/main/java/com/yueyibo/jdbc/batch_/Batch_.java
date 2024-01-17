package com.yueyibo.jdbc.batch_;

import com.yueyibo.jdbc.utils.JDBCUtils_;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Batch_ {

    //传统方法，添加 5000 条数据到 admin2
    @Test
    public void noBatch() throws Exception {
        Connection connection = JDBCUtils_.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {//5000 执行
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统的方式 耗时=" + (end - start));//传统的方式 耗时=383979
        //关闭连接
        JDBCUtils_.close(null, preparedStatement, connection);
    }

    //先将表删除重建再试
    //使用批量方式添加数据   注意添加参数rewriteBatchedStatements=true
    @Test
    public void batch() throws Exception {
        Connection connection = JDBCUtils_.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {//5000 执行
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            //将 sql 语句加入到批处理包中 -> 看源码
            /*
            //1. //第一就创建 ArrayList - elementData => Object[]
            //2. elementData => Object[] 就会存放我们预处理的 sql 语句
            //3. 当 elementData 满后,就按照 1.5 扩容
            //4. 当添加到指定的值后，就 executeBatch
            //5. 批量处理会减少我们发送 sql 语句的网络开销，而且减少编译次数，因此效率提高
            public void addBatch() throws SQLException {
                synchronized(this.checkClosed().getConnectionMutex()) {
                    if (this.batchedArgs == null) { //第一就创建 ArrayList - elementData => Object[]
                        this.batchedArgs = new ArrayList();
                    }
                    for(int i = 0; i < this.parameterValues.length; ++i) {
                        this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
                    }
                    this.batchedArgs.add(new PreparedStatement.BatchParams(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
                }
            }
            */
            preparedStatement.addBatch();
            //当有 1000 条记录时，在批量执行
            if((i + 1) % 1000 == 0) {//满 1000 条 sql
                preparedStatement.executeBatch();
                //清空一把
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批量方式 耗时=" + (end - start));//批量方式 耗时=2355
        //关闭连接
        JDBCUtils_.close(null, preparedStatement, connection);
    }
}
