package com.yueyibo.lab.lab2_2;

public class Lab2_2 {
    public static void main(String[] args) {
        //属性直接被方法赋值，不能被用户操作，怎么实现（主要是作用域的问题：可以直接将其放在方法体中不需要在属性中出现，但题目要求是class的属性）
        Triangle triangle = new Triangle(2, -2, 3);
        triangle.setSideB(-1);
        triangle.setSideB(4);
        triangle.setSideA(5);
        System.out.println(triangle.isTriangle());
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getArea());

        Trapezoid trapezoid = new Trapezoid(3.0, 6.0, 2.0);
        trapezoid.setHeight(-1);
        trapezoid.setHeight(3.0);
        System.out.println(trapezoid.getArea());

        Circle circle = new Circle(2.4);
        circle.setRadius(2.0);
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
    }
}