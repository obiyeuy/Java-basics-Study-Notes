package com.yueyibo.lab.lab3_1;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, Book> books = new HashMap<String, Book>();
        System_.insert(books,"云边有个小卖部",new Book("云边有个小卖部","张嘉佳","湖南文艺出版社","4516c","2018.7",305,"云边有个小卖部"));
        System_.insert(books,"白夜行",new Book("白夜行","东野圭吾","南海出版公司","45678bwheqj","2008.9",538,"白夜行"));
        System_.insert(books,"走到人生边上",new Book("走到人生边上","杨绛","商务印书馆","wqyguwh132","2007.8",190,"走到人生边上"));
        System_.delete(books,"走到人生边上");
        System_.delete(books,"走到人生边上");
        System.out.println(System_.search(books, "走到人生边上"));
        System.out.println(System_.search(books, "云边有个小卖部"));
    }
}
