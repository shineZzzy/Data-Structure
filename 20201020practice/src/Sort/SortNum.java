package Sort;

import java.util.Random;

public class SortNum {

    public static void main(String[] args) {
        int[] arr = new int[10]; // 定义一个有是个数字的数组
        Random rm = new Random(1021); // 初始化随机数的对象
        System.out.print("[");
        for (int i = 0 ; i < 10 ; i++) {
            arr[i] = rm.nextInt(100); // 从100以内随机选择一个数字
            System.out.print(arr[i]); // 打印输出数组第i个数字的值
        }
        System.out.print("]\n");
        int temp = 0 ; // 临时变量
        int len = arr.length ;
        // 从右向左遍历，默认每次最右边的数字都是排序结束的数字
        for (int j = len - 1; j > 0  ; j--) {
            // 从左向右遍历，将未排序的数组中的最大数字运送到剩余数组的最右边
            for (int i = 0 ; i <= j - 1 ; i++) {
                if (arr[i] > arr[i+1]) { // 如果左边的值比右边的值大，则交换两者的位置
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            // 每次循环结束，都有一个最大的数字送到右侧，按大小从右向左排序。
        }
        // 打印输出排序后的数组
        System.out.print("[");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.print("]");

    }
}

