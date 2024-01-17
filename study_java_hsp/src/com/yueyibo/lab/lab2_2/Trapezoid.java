package com.yueyibo.lab.lab2_2;


public class Trapezoid {
    private double upper_bottom;
    private double lower_bottom;
    private double height;
    private double area;

    public Trapezoid() {
    }

    public Trapezoid(double upper_bottom, double lower_bottom, double height) {
        setUpper_bottom(upper_bottom);
        setLower_bottom(lower_bottom);
        setHeight(height);
    }

    public void setLower_bottom(double lower_bottom) {
        if (lower_bottom > 0) {
            this.lower_bottom = lower_bottom;
        } else {
            System.out.println("底边请输入一个正数，程序员已经将其置为默认值0~");
            this.lower_bottom = 0;
        }
    }

    public void setUpper_bottom(double upper_bottom) {
        if (upper_bottom > 0) {
            this.upper_bottom = upper_bottom;
        } else {
            System.out.println("上边请输入一个正数，程序员已经将其置为默认值0~");
            this.upper_bottom = 0;
        }
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("高请输入一个正数，程序员已经将其置为默认值0~");
            this.height = 0;
        }
    }

    public double getLower_bottom() {
        return lower_bottom;
    }

    public double getUpper_bottom() {
        return upper_bottom;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        area = (upper_bottom + lower_bottom) * height / 2;
        return area;
    }
}
