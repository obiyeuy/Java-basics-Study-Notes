package com.yueyibo.lab;

public class dawu {
    public static void main(String[] args) {
        double f1[] = {0.4562,1.4408,2.3638,3.3985,4.3331,5.2562,6.2408,7.1638,8.1485,9.1331};
        double f2[] = new double[]{0.4899,1.4698,2.4497,3.4296,4.4095,5.3893,6.3692,7.3491,8.3290,9.3089};
        double sum = 0;
        for (int i  =0;i<10;++i) {
            double f = (f2[i]-f1[i])/f2[i];
            sum +=f;
            System.out.println(f);
        }
        System.out.println();
        System.out.println(sum/10);
    }
}
