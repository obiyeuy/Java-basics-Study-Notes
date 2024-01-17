package com.yueyibo.lab.lab2_2;

public class Circle {
    private double radius;
    private double perimeter;
    private double area;

    public Circle() {
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    public void setRadius(double radius) {

        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("半径请输入一个正数，程序员已经将其置为默认值0~");
            this.radius = 0;
        }
    }

    public double getRadius() {
        return radius;
    }

    public double getPerimeter() {
        perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    public double getArea() {
        area = Math.PI * radius * radius;
        return area;
    }
}