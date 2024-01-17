package com.yueyibo.lab.lab3_1;

import java.util.HashMap;

public class System_ {
    public static void insert(HashMap<String, Book> map, String name, Book book) {
        if (!map.containsKey(name)) {
            map.put(name, book);
            System.out.println(name + "插入成功");
        } else {
            System.out.println("系统中已有" + name + ",插入失败");
        }
    }

    public static void delete(HashMap<String, Book> map, String name) {
        if (map.containsKey(name)) {
            map.remove(name);
            System.out.println(name + "删除成功");
        } else {
            System.out.println("系统中没有" + name + ",删除失败");
        }
    }

    public static Book search(HashMap<String, Book> map, String name) {
        return map.get(name) == null ? null : map.get(name);
    }
}
