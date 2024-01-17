package welcome;


import java.util.Arrays;
public class ShuZuDeCeShi {
    public static void main(String[]args) {
        int[] a = {12, 324, 12, 4, 133, 31};

        System.out.println(Arrays.toString(a));  //测试打印
        Arrays.sort(a);
        System.out.println( Arrays.toString(a));  //测试排序

        //测试二分法查找（必须先排序）  在数组中找输入的数，返回数所在的排序位置，没找到则返回一个负数 首位是0（排序）
        System.out.println("该元素的索引："+Arrays.binarySearch(a,12));

        //测试填充
        int[] b= {12, 324, 12, 4, 133, 31};
        System.out.println(Arrays.toString(b));
        Arrays.fill(b,2,4,100) ; //把2到4索引的元素替换为100  包头不包尾，即替换2，3位的元素
        System.out.println(Arrays.toString(b));



    }
}
