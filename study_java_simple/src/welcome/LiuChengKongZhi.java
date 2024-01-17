package welcome;

import java.util.Scanner;

public class LiuChengKongZhi {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入月份：");
        int month = scanner.nextInt();
        switch (month){
            case 1:
            case 2:
            case 12:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("输入有误");
        }

    }
}
