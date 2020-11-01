package Sort;

import java.util.Arrays;
import java.util.Random;

public class Sort4 {
    public static void swap(long[] arr,int i,int j){
        long t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    public static void bubbleSort(long[] array) {

        // 需要多少次冒泡过程
        for (int i = 0; i < array.length - 1; i++) {
            // 无序： [0, array.length - i)
            // 有序： [array.length - i, array.length)

            // 每次冒泡之前，假设数组已经有序
            boolean isSorted = true;

            // 进行冒泡过程
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);

                    isSorted = false;
                }
            }
                if (isSorted) {
                    break;
                }
            }
    }
    public static void main(String[] args) {
        long[] array=new long[10];
        Random random=new Random(20201022);
        for(int i=0;i<10;i++){
            array[i]=random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
