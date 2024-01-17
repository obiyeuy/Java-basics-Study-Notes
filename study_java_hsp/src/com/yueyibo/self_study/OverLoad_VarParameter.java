package com.yueyibo.self_study;

public class OverLoad_VarParameter {
    public static void main(String[] args){
        Mycalculator t  = new Mycalculator();
        t.calculator(6,6.0);
        t.calculator(6.0,8);
        t.calculator(3.0,9.0);
        t.calculator(3,10); //方法重载

        t.sum(2,3,41,3,4,234,2,45,2,1,234); //可变参数
        int[] arr = {1,31,131,2321,3213};
        t.sum(arr);  //可变参数的实参可以为数组

    }
}

class Mycalculator{
    public int calculator(int n,int m){
        System.out.println("calculator(int n,int m)");
        return n+m;
    }
    public double calculator(int n,double m){
        System.out.println("calculator(int n,double m)");
        return n+m;
    }
    public double calculator(double n,int m){
        System.out.println("calculator(double n,int m)");
        return n+m;
    }
    public double calculator(double n,double m){
        System.out.println("calculator(double n,double m)");
        return n+m;
    }
    public int sum(int... nums){
        System.out.println("接收参数个数="+nums.length);
        int res = 0;
        for(int i = 0;i<nums.length;++i){
            res +=nums[i];
        }
        return res;
    }
    public void f3(String str,int...nums1){

    }//可变参数可以和普通类型的参数一起放在形参列表，但必须保证可变参数在最后

    //一个形参列表中只能出现一个可变参数
    //public void f4(int...nums1,double...nums2){
    //}
}


