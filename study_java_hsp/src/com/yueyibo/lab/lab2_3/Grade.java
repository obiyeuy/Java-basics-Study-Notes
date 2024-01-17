package com.yueyibo.lab.lab2_3;

public class Grade{
    String nameOfStudent;
    String nameOfCourse;
    int grade;

    public Grade(String nameOfCourse,String nameOfStudent,int grade){
        this.grade = grade;
        this.nameOfCourse = nameOfCourse;
        this.nameOfStudent = nameOfStudent;
    }
}