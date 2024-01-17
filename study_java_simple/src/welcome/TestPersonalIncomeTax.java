package welcome;


import java.util.Scanner;

public class TestPersonalIncomeTax {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入月薪：");
            double slary = scanner.nextInt();
            double jiao = slary - 5000;
            double shui = 0;

            if (jiao < 0) {
                System.out.println(shui);
            } else if (jiao <= 3000) {
                shui = jiao * 0.03;
                slary -= shui;
            } else if (jiao <= 12000) {
                shui = jiao * 0.1 - 210;
                slary -= shui;
            } else if (jiao <= 25000) {
                shui = jiao * 0.2 - 1410;
                slary = shui;
            } else if (jiao <= 35000) {
                shui = jiao * 0.25 - 2660;
                slary -= shui;
            } else if (jiao <= 55000) {
                shui = jiao * 0.3 - 4410;
                slary -= shui;
            } else {
                shui = jiao * 0.45 - 15160;
                slary -= shui;
            }
            System.out.println("应纳税所得额：" + jiao + "元\t" + "纳税税额" + shui + "元\t" + "实发工资" + slary + "元");
            System.out.println("输入exit退出程序，其他继续计算");
        }
    }
}
