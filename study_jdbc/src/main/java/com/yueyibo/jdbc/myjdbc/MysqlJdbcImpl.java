package com.yueyibo.jdbc.myjdbc;

public class MysqlJdbcImpl implements JdbcInterface{

    @Override
    public Object getConnection() {
        System.out.println("连接到mysql");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成mysql的增删改查");
    }

    @Override
    public void close() {
        System.out.println("断开连接");
    }
}
