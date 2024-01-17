package com.yueyibo.self_study.enumeration;

public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println(Season01.AUTUMN);
        System.out.println(Season01.SPRING);
    }
}


class Season01{
    private String name;
    private String desc;

    public static final Season01 SPRING = new Season01("春天","温暖");
    public static final Season01 WINTER= new Season01("冬天","寒冷");
    public static final Season01 AUTUMN = new Season01("秋天","凉爽");
    public static final Season01 SUMMER = new Season01("夏天","炎热");

    public Season01(String name,String desc){
        this.desc = desc;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String toString(){
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
