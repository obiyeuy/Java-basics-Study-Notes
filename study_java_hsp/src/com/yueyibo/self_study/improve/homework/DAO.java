package com.yueyibo.self_study.improve.homework;


import java.util.*;
//定义个泛型类DAO<T>,在其中定义一个Map成员变量，Map的键为String类型，值为T类型。
//分别创建以下方法：
//1)public void save(String id,T entity):保存T类型的对象到Map成员变量中
//2)public T get(String id):从map中获取id对应的对象
//3)public void update(String id,T entity):替换map中key为id的内容，改为entity对象
//4)public List<T>Iist0:返回map中存放的所有T对象
//5)public void delete(String id):删除指定id对象

//定义一个User类：
//该类包含：private成员变量(int类型)id,age;(String类型)name。
//创建DAO类的对象，分别调用其save、get、update、Iist、delete方法来操作User对像，
//使用nit单元测试类进行测试。
public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            list.add(get(key));
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }

    public void save(String id, T entity) {
        map.put(id, entity);
    }
}
