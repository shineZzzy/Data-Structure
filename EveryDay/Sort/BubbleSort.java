package Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] n) {
        //n个数，冒泡(n-1)或n次
        for (int i = 0; i <n.length-1 ; i++) {
            //优化：假设排序前数组有序
            boolean isSorted=true;
            //遍历无序区间，只需要对无序区间进行处理
            //无序[0,n.length-i)  有序[n.length-i,n.length)
            for (int j = 0; j <n.length-i-1 ; j++) {
                if (n[j]>n[j+1]){
                    //如果当前元素>下一个，说明数组无序，交换这两个元素
                    swap(n,j,j+1);
                    isSorted=false;
                }
            }
            //当最终假设成立时，说明数组整体已完全有序
            if (isSorted){
                break;
            }
        }
        System.out.println(Arrays.toString(n));
    }
    private static void swap(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    public static void main(String[] args) {
        int[] n={1,5,3,2,4,1,5,7,6};
        bubbleSort(n);
    }
}
