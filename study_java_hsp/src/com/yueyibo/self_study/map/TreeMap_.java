package com.yueyibo.self_study.map;

import java.util.Comparator;
import java.util.TreeMap;

@SuppressWarnings({"all"})
public class TreeMap_ {
    public static void main(String[] args) {
        //使用默认的构造器，创建 TreeMap, 是无序的(也没有排序)
        /*
        要求：按照传入的 k(String) 的大小进行排序
        */
        // TreeMap treeMap = new TreeMap();
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
            //按照传入的 k(String) 的大小进行排序
            //按照 K(String) 的长度大小排序
            //return ((String) o2).compareTo((String) o1);
                return ((String) o2).length() - ((String) o1).length();
            }
        });
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("kristina", "克瑞斯提诺");
        treeMap.put("smith", "斯密斯");
        treeMap.put("hsp", "韩顺平");//加入不了
        System.out.println("treemap=" + treeMap);
        /*
        1. 构造器. 把传入的实现了 Comparator 接口的匿名内部类(对象)，传给给 TreeMap 的 comparator
        public TreeMap(Comparator<? super K> comparator) {
            this.comparator = comparator;
        }
        2. 调用 put 方法
        2.1 第一次添加, 把 k-v 封装到 Entry 对象，放入 root
        Entry<K,V> t = root;
        if (t == null) {
            compare(key, key);  // type (and possibly null) check
            root = new Entry<>(key, value, null);
            size = 1;
            modCount++;
            return null;
        }
        2.2 以后添加
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            do {    //遍历所有的 key , 给当前 key 找到适当位置
                parent = t;
                cmp = cpr.compare(key, t.key);//动态绑定到我们的匿名内部类的 compare
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else //如果遍历过程中，发现准备添加 Key 和当前已有的 Key 相等，就不添加
                return t.setValue(value);
            } while (t != null);
        }
        */
    }
}
