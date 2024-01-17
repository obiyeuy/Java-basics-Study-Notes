package com.yueyibo.lab.lab3_1;

public class Book {
    private String name;
    private String author;
    private String publisher;
    private String No;
    private String date;
    private int pages;
    private String abstract_;

    public Book(String name, String author, String publisher, String no, String date, int pages, String abstract_) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        No = no;
        this.date = date;
        this.pages = pages;
        this.abstract_ = abstract_;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAbstract_() {
        return abstract_;
    }

    public void setAbstract_(String abstract_) {
        this.abstract_ = abstract_;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", No='" + No + '\'' +
                ", date='" + date + '\'' +
                ", pages=" + pages +
                ", abstract_='" + abstract_ + '\'' +
                '}';
    }
}
