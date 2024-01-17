package com.yueyibo.self_study.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("all")
public class MapExercise {
    public static void main(String[] args) {
        Map hashMap = new HashMap();

        //添加对象
        hashMap.put(1, new Emp("jack", 300000, 1));
        hashMap.put(2, new Emp("tom", 21000, 2));
        hashMap.put(3, new Emp("milan", 12000, 3));

        //遍历 2 种方式
        //并遍历显示工资>18000 的员工(遍历方式最少两种)
        //1. 使用 keySet -> 增强 for
        Set keySet = hashMap.keySet();
        System.out.println("第一种遍历方式：");
        for(Object key : keySet){
            //先获取 value
            Emp emp = (Emp)hashMap.get(key);
            if(emp.getSal()>18000){
                System.out.println(emp);
            }
        }

        //2. 使用 EntrySet -> 迭代器
        // 体现比较难的知识点
        // 慢慢品，越品越有味道.
        Set entrySet = hashMap.entrySet();
        System.out.println("第二种遍历方式：");
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry)iterator.next();
            //通过 entry 取得 key 和 value
            Emp emp = (Emp)entry.getValue();
            if(emp.getSal()>18000){
                System.out.println(emp);
            }
        }
    }
}


/*
* 使用 HashMap 添加 3 个员工对象，要求
* 键：员工 id
* 值：员工对象
*
* 并遍历显示工资>18000 的员工(遍历方式最少两种)
* 员工类：姓名、工资、员工 id
*/
class Emp {
    private String name;
    private double sal;
    private int id;
    public Emp(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}
