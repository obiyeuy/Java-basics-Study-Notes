package com.yueyibo.self_study;

public class Interface {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        t(mysqlDB);
        OracleDB oracleDB = new OracleDB();
        t(oracleDB);
    }

    private static void t(DBInterface db) {
        db.connect();
        db.close();
    }
}

interface DBInterface {
    public void connect();

    public void close();
}

class MysqlDB implements DBInterface {
    public void connect() {
        System.out.println("连接mysql");
    }

    public void close() {
        System.out.println("关闭mysql");
    }

}

class OracleDB implements DBInterface {
    public void connect() {
        System.out.println("连接oracle");
    }

    public void close() {
        System.out.println("关闭oracle");
    }
}
