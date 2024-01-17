package com.yueyibo.self_study.enumeration;

public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season02.AUTUMN);
        System.out.println(Season02.SUMMER);
    }
}

enum Season02 {
    SPRING("春天", "温暖"), WINTER("冬天", "寒冷"), AUTUMN("秋天", "凉爽"), SUMMER("夏天", "炎热");

    private String name;
    private String desc;

    private Season02() {
    }

    private Season02(String name, String desc) {
        this.desc = desc;
        this.name = name;
    }

    public String getName() {
        return name;

    }

    public String getDesc() {
        return desc;
    }

    public String toString() {
        return "Season{" +
                "name=" + name + '\'' +
                ",desc=" + desc + '\'' +
                "}";
    }
}
