package com.yueyibo.self_study.single_ton;
/**
 * 演示饿汉式的單例模式
 */
public class SingleTon01 {
    public static void main(String[] args) {
        // GirlFriend xh = new GirlFriend("小红");
        // GirlFriend xb = new GirlFriend("小白");
        //通过方法可以获取对象
        GirlFriend instance1 = GirlFriend.getInstance();
        System.out.println(instance1);
        GirlFriend instance2 = GirlFriend.getInstance();
        System.out.println(instance2);
        System.out.println(instance1 == instance2);//T
        //System.out.println(GirlFriend.n1);
        //... }
    }

    //有一个类， GirlFriend
    //只能有一个女朋友
    static class GirlFriend {
        private String name;

        //为了能够在静态方法中，返回 gf 对象，需要将其修饰为 static
        //對象，通常是重量級的對象, 餓漢式可能造成創建了對象，但是沒有使用.
        private static GirlFriend gf = new GirlFriend("小红红");
        //如何保障我们只能创建一个 GirlFriend 对象

        //步骤[单例模式-饿汉式]
        //1. 将构造器私有化
        //2. 在类的内部直接创建对象(该对象是 static)
        //3. 提供一个公共的 static 方法，返回 gf 对象
        private GirlFriend(String name) {
            System.out.println("构造器被调用.");
            this.name = name;
        }

        public static GirlFriend getInstance() {
            return gf;
        }

        @Override
        public String toString() {
            return "GirlFriend{" +
                    "name='" + name + '\'' +
                    '}';
        }

    }
}