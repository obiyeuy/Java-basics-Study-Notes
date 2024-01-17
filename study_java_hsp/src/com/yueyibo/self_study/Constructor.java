package com.yueyibo.self_study;

public class Constructor {
    public static void main(String[] args) {
        Person p1 = new Person("john", 16);
        System.out.println("name=" + p1.name + ",age=" + p1.age);

        Person p2 = new Person();
        p2.age = 13;
        p2.name = "lily";

        Person p3 = new Person("john", 16);
        System.out.println("p1与p3比较结果：" + p3.compareTo(p1));
    }
}

class Person {
    String name;
    int age;

    public Person() {  //显式的重载一下，不然不能使用无参构造器
    }
//    public Person(String pname,int page){ //名字感觉不爽，之后使用this关键字进行改进
//        System.out.println("构造器被调用~完成对象的属性初始化");
//        name = pname;
//        age = page;
//    }

    public Person(String name, int age) {  //重载需要形参列表不同，将上面注释掉
        System.out.println("构造器被调用~完成对象的属性初始化");
        //this.name就是当前对象的属性name
        this.name = name;
        //this.age就是当前对象的属性age
        this.age = age;
    }

    public boolean compareTo(Person p) {
        return this.name.equals(p.name) && this.age == p.age;
    }
}
