package welcome;

public class Array {
    public static void main(String[] args) {
        String[] arr = {"AA", "DD", "EE", "GG"};

        String dest = "BB";

        for (int i = 0; i < arr.length; i++) {
            if (dest.equals(arr[i])) {
                System.out.println("找到了，在" + i);
                break;
            }
        }
        System.out.println("没找到");

        //二分法查找
        int[] arr1 = new int[]{13, 23, 435, 1321, 4545, 5};

        int dest1 = 435;
        int head = 0; //初始的首索引
        int end = arr1.length - 1; //初始的末索引
        boolean isFlag = true;

        while (head <= end) {

            int middle = (head + end) / 2;
            if (dest1 == arr1[middle]) {
                System.out.println("找到了，位置为：" + middle);
                isFlag = false;
                break;
            } else if (arr1[middle] > dest1) {
                end = middle - 1;
            } else { //arr1[middle]<dest1
                head = middle + 1;
            }

        }
    }
}
