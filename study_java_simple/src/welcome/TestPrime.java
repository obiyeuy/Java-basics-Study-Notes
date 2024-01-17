package welcome;

import java.util.Scanner;

public class TestPrime {
    public static void main(String[] args) {
        while (true) {
            System.out.print("请输入一个整数：");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            int i = 2;
            while (i < num) {
                if (num % i == 0) {
                    System.out.println("这个数不是质数！");
                    break;
                }
                i++;
            }
            if (i == num) {
                System.out.println("这个数是一个质数。");
            }
            System.out.println("输入exit退出程序，其他继续计算");
        }
    }
}
