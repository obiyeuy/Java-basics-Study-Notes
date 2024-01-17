package welcome;

import java.util.Arrays;
import java.util.Scanner;

public class TestArray {
    public static void main(String[] args) {
        int[] arr1 = new int[6];
        int[] arr2 = new int[6];
        System.out.println("输入数组元素，总计六个：");
        for (int i = 1; i <= 6; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入一个整数：");
            int num = sc.nextInt();
            arr1[i - 1] = num;
        }
        for (int i = 1; i <= 6; i++) {
            arr2[i - 1] = arr1[6 - i];
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }
}

