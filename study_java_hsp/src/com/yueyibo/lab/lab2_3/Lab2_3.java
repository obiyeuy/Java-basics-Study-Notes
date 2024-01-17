package com.yueyibo.lab.lab2_3;

import java.util.*;

public class Lab2_3 {
    public static void main(String[] args) {
        Student student1 = new Student("小张", 01, '男', 13);
        Student student2 = new Student("小李", 02, '男', 15);
        Student student3 = new Student("小王", 03, '女', 14);
        Student student4 = new Student("小孙", 04, '男', 14);
        Student student5 = new Student("小钱", 05, '女', 13);
        List<Student> Students = new ArrayList<>();
        Students.add(student1);
        Students.add(student2);
        Students.add(student3);
        Students.add(student4);
        Students.add(student5);

        Course course1 = new Course(01, "Java程序设计", 6);
        Course course2 = new Course(02, "数据结构", 4);
        Course course3 = new Course(03, "数理逻辑与近世代数", 8);
        List<Course> Courses = new ArrayList<>();
        Courses.add(course1);
        Courses.add(course2);
        Courses.add(course3);

        Grade grade1 = new Grade("Java程序设计", "小李", 92);
        Grade grade2 = new Grade("Java程序设计", "小张", 85);
        Grade grade3 = new Grade("Java程序设计", "小王", 79);
        Grade grade4 = new Grade("Java程序设计", "小孙", 86);
        Grade grade5 = new Grade("Java程序设计", "小钱", 93);
        Grade grade6 = new Grade("数据结构", "小李", 91);
        Grade grade7 = new Grade("数据结构", "小张", 83);
        Grade grade8 = new Grade("数据结构", "小王", 83);
        Grade grade9 = new Grade("数据结构", "小孙", 88);
        Grade grade10 = new Grade("数据结构", "小钱", 95);
        Grade grade11 = new Grade("数理逻辑与近世代数", "小李", 94);
        Grade grade12 = new Grade("数理逻辑与近世代数", "小张", 86);
        Grade grade13 = new Grade("数理逻辑与近世代数", "小王", 87);
        Grade grade14 = new Grade("数理逻辑与近世代数", "小孙", 90);
        Grade grade15 = new Grade("数理逻辑与近世代数", "小钱", 97);
        List<Grade> Grades = new ArrayList<>();
        Grades.add(grade1);
        Grades.add(grade2);
        Grades.add(grade3);
        Grades.add(grade4);
        Grades.add(grade5);
        Grades.add(grade6);
        Grades.add(grade7);
        Grades.add(grade8);
        Grades.add(grade9);
        Grades.add(grade10);
        Grades.add(grade11);
        Grades.add(grade12);
        Grades.add(grade13);
        Grades.add(grade14);
        Grades.add(grade15);

        double total = 0;
        int credits = 0;
        int count = 0;
        for (Student s : Students) {
            for (Grade g : Grades) {
                if (s.name.equals(g.nameOfStudent)) {
                    total += g.grade;
                    count++;
                    for (Course c : Courses) {
                        if (g.nameOfCourse.equals(c.nameOfCourse)) {
                            credits += c.credit;
                        }
                    }
                }
            }
            s.average = total / count;
            System.out.println(s.name + "的总成绩是" + total + ",平均成绩是" + s.average + ",总学分是" + credits + ".");
            count = 0;
            total = 0;
            credits = 0;
        }
        System.out.println();


        int flag[] = new int[Students.size()];
        for (int i = 0; i < Students.size() - 1; i++) {

            double averageOfClass = Students.get(i).average;
            int countOfStudent = 1;
            if (flag[i] == 0) {
                flag[i] = 1;
                for (int j = i + 1; j < Students.size(); j++) {
                    if (Students.get(j).banji == Students.get(i).banji) {
                        flag[j] = 1;
                        averageOfClass += Students.get(j).average;
                        countOfStudent++;
                    }
                }
                System.out.println(Students.get(i).banji + "班平均成绩为" + averageOfClass / countOfStudent);
            }
        }
        System.out.println();


        for (int i = 0; i < Students.size() - 1; i++) {
            for (int j = 0; j < Students.size() - 1 - i; j++) {
                if (Students.get(j).average < Students.get(j+1).average) {
                    Collections.swap(Students, j, j+1);
                }
            }
        }
        for (int i = 0; i < Students.size(); i++){
            System.out.println(Students.get(i).name+"平均成绩是"+Students.get(i).average);
        }
        System.out.println();


        for (Course c : Courses) {
            for (Grade g : Grades) {
                if (c.nameOfCourse.equals(g.nameOfCourse)) {
                    total += g.grade;
                    count++;
                }
            }
            System.out.println(c.nameOfCourse + "的平均成绩是" + total / count + ".");
            count = 0;
            total = 0;
        }
    }
}









