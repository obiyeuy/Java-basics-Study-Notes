package com.yueyibo.self_study;

public class Extends {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "小申申";
        pupil.age = 9;
        pupil.testing();
        pupil.setScore(59);
        pupil.showInfo();

        System.out.println("=============");
        Graduate graduate = new Graduate();
        graduate.name = "老东西";
        graduate.age = 18;
        graduate.testing();
        graduate.setScore(99);
        graduate.showInfo();
    }
}


class Student {   //用于测试继承Extends
    public String name;
    public  int age;
    private double score;

    public  void setScore(double score){
        this.score = score;
    }

    public void showInfo(){
        System.out.println("学生名:"+name+" 年龄:"+age+" 成绩:"+score);
    }
}

class Pupil extends Student {   //用于测试继承Extends
    public void testing(){
        System.out.println("小学生"+name+"正在考数学..");
    }
}

class Graduate extends Student{   //用于测试继承Extends
    public void testing(){
        System.out.println("大学生"+name+"正在考数学..");
    }
}
