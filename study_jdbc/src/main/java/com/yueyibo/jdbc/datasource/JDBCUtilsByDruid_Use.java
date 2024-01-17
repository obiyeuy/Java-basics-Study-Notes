package com.yueyibo.jdbc.datasource;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

public class JDBCUtilsByDruid_Use {
    @Test
    public void testSelect() {
        System.out.println("使用 druid 方式完成");
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个 sql
        String sql = "select * from beauty where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3. 创建 PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass()); //运行类型 com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1); //给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name"); //getName()
                String sex = set.getString("sex"); //getSex()
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
    }

    //使用老师的土方法来解决 ResultSet =封装=> Arraylist
    @Test
    public void testSelectToArrayList() {
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个 sql
        String sql = "select * from beauty where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<Beauty> list = new ArrayList<>();//创建 ArrayList 对象,存放 beauty 对象
        //3. 创建 PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());//运行类型 com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);//给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");//getName()
                String sex = set.getString("sex");//getSex()
                String borndate = set.getString("borndate");
                String phone = set.getString("phone");
                Blob photo = set.getBlob("photo");
                int boyfriend_id = set.getInt("boyfriend_id");
                //把得到的 resultset 的记录，封装到 Actor 对象，放入到 list 集合
                if(photo == null){
                    list.add(new Beauty(id, name, sex, borndate, phone, null, boyfriend_id));
                }else{
                    list.add(new Beauty(id, name, sex, borndate, phone, photo.toString(), boyfriend_id));

                }
            }
//            System.out.println("list 集合数据=" + list);
            for(Beauty beauty : list) {
                System.out.println(beauty.getId() + "\t" + beauty.getName()+ "\t" + beauty.getBoyfrieng_id());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
        //因为 ArrayList 和 connection 没有任何关联，所以该集合可以复用.
//        return list;
    }
}
