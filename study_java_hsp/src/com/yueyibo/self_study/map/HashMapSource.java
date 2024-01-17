package com.yueyibo.self_study.map;

import java.util.HashMap;

@SuppressWarnings({"all"})
public class HashMapSource {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("java", 10);//ok
        map.put("php", 10);//ok
        map.put("java", 20);//替换 value
        System.out.println("map=" + map);
/*解读 HashMap 的源码
1. 执行构造器 new HashMap()
    初始化加载因子 loadfactor = 0.75
    HashMap$Node[] table = null

2. 执行 put 调用 hash 方法，计算 key 的 hash 值 (h = key.hashCode()) ^ (h >>> 16)
    public V put(K key, V value) {      //K = "java" value = 10
        return putVal(hash(key), key, value, false, true);
    }

3. 执行 putVal
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;//辅助变量
        //如果底层的 table 数组为 null, 或者 length =0 , 就扩容到 16
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;

        //取出 hash 值对应的 table 的索引位置的 Node, 如果为 null, 就直接把加入的 k-v创建成一个 Node ,加入该位置即可
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);

        else {
            Node<K,V> e; K k;   //辅助变量
            // 如果 table 的索引位置的 key 的 hash 相同和新的 key 的 hash 值相同，
            // 并 满足(table 现有的结点的 key 和准备添加的 key 是同一个对象 || equals 返回真)
            // 就认为不能加入新的 k-v
            if (p.hash == hash &&((k = p.key) == key || (key != null && key.equals(k))))
                e = p;

            else if (p instanceof TreeNode)    //如果当前的 table 的已有的 Node 是红黑树，就按照红黑树的方式处理
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);

            else {
                //如果找到的结点，后面是链表，就循环比较
                for (int binCount = 0; ; ++binCount) {  //死循环
                    if ((e = p.next) == null) {   //如果整个链表，没有和他相同,就加到该链表的最后
                        p.next = newNode(hash, key, value, null);

                        //加入后，判断当前链表的个数，是否已经到 8 个，到 8 个后就调用 treeifyBin 方法进行红黑树的转换
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }

                    //如果在循环比较过程中，发现有相同,就 break,就只是替换 value
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }

            if (e != null) {    // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;   //替换，key 对应 value

                afterNodeAccess(e);
                return oldValue;
            }
        }

        ++modCount; //每增加一个 Node ,就 size++
        if (++size > threshold)   //如 size > 临界值[12->24->48]，就扩容
            resize();

        afterNodeInsertion(evict);
        return null;
    }

5. 关于树化(转成红黑树)
    //如果 table 为 null ,或者大小还没有到 64，暂时不树化，而是进行扩容.
    //否则才会真正的树化 -> 剪枝
    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();
    }
*/
    }
}
