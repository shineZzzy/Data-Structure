package Sort;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] n) {
        //n个数，排(n-1)趟
        for (int i = 0; i <n.length-1 ; i++) {
            //将数组划分为有序、无序区间
            //有序：[0,i]  无序：[i+1,n.length)

            //无序区间第一个元素作为key
            int key=n[i+1];
            int j=0;
            //遍历有序区间，与key比较
            for (j = i; j>=0; j--) {
                //情况3
                if (key<n[j]){
                    n[j+1]=n[j];
                }else {
                    //情况1、2
                    break;
                }
            }
            n[j+1]=key;
        }
        System.out.println(Arrays.toString(n));
    }
    public static void main(String[] args) {
        int[] n={1,5,3,2,4,1,5,7,6};
        insertSort(n);
    }
}
