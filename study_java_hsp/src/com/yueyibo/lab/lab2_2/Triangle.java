package com.yueyibo.lab.lab2_2;

public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;
    private double perimeter;
    private double area;
    boolean isTriangle;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) {
        setSideA(sideA);
        setSideB(sideB);
        setSideC(sideC);
    }

    public void setSideA(double sideA) {
        if (sideA > 0) {
            this.sideA = sideA;
        } else {
            System.out.println("A边请输入一个正数，程序员已经将其置为默认值0~");
            this.sideA = 0;
        }
    }

    public void setSideB(double sideB) {
        if (sideB > 0) {
            this.sideB = sideB;
        } else {
            System.out.println("B边请输入一个正数，程序员已经将其置为默认值0~");
            this.sideB = 0;
        }
    }

    public void setSideC(double sideC) {
        if (sideC > 0) {
            this.sideC = sideC;
        } else {
            System.out.println("C边请输入一个正数，程序员已经将其置为默认值0~");
            this.sideC = 0;
        }
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double getPerimeter() {
        if (isTriangle) {
            perimeter = sideA + sideB + sideC;
            return perimeter;
        } else {
            System.out.println("三边不能构成一个三角形~");
            return 0;
        }
    }

    public double getArea() {
        if (isTriangle) {
            area = Math.sqrt(getPerimeter() * (getPerimeter() - 2 * sideA) * (getPerimeter() - 2 * sideB) * (getPerimeter() - 2 * sideC)) / 4;
            return area;
        } else {
            System.out.println("三边不能构成一个三角形~");
            return 0;
        }
    }

    public boolean isTriangle() {
        if (sideA > 0 && sideB > 0 && sideC > 0) {
            isTriangle = (sideA + sideB > sideC) && (sideB + sideC > sideA) && (sideC + sideA > sideB);
            return isTriangle;
        }
        return false;
    }
}
