package welcome;

import java.util.Arrays;
public class DuoWeiShuZu {

    public static void main(String[]args){

        int[][]a=new int[3][];
        a[0]=new int[2];
        a[1]=new int[3];
        a[2]=new int[4];
        //int[][]a=new int[][4];//非法

        //多维数组的静态初始化
        int[][]b={{2,3,4},{3,4},{7,5,3,2}};
        System.out.println(b[2][3]);

        //多维数组的动态初始化
        int[][]c=new int[3][];
         // a[0]={1,2}; //错误，没有声明类型就初始化
        c[0]=new int[]{1,2};
        c[1]=new int[]{3,2};
        c[2]=new int[]{3,2,4};
        System.out.println(c[2][2]);
        System.out.println(Arrays.toString(c[1]));

        //获取a的第一维数组的长度
        System.out.println(a.length);
        //获取a的二维数组的第二个数组长度
        System.out.println(a[1].length);
    }
}
