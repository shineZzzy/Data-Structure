package Sort;

import java.util.Arrays;

public class selectSort {
//    public static void selSort(int[] array){
//        for(int i=0;i<array.length-1;i++){
//            int maxIndex=0;
//            for(int j=1;j<array.length-i;j++){
//                if(array[j]>array[maxIndex]){
//                    maxIndex=j;
//                }
//            }
//            swap(array,maxIndex,array.length-i-1);
//        }
//        System.out.println(Arrays.toString(array));
//    }

    public static void selSort(int[] array){
        //n个数，需要比较(n-1)趟
        for (int i = 0; i <array.length-1 ; i++) {
            //1.假设第0号下标的元素为最大元素
            int maxIndex=0;
            //区间划分
            //无序区间：[0,array.length-i)
            //有序区间：[array.length-i,array.length)
            //遍历找最大元素
            for (int j = 1; j <array.length-i; j++) {
                if (array[j]>array[maxIndex]){
                    maxIndex=j;
                }
            }
            //找到最大元素，将其与无序区间的最后一个元素进行交换
            swap(array,maxIndex,array.length-i-1);
        }
        System.out.println(Arrays.toString(array));
    }

    private static void swap(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public static void main(String[] args) {
        int[] n={1,5,3,2,4,1,5,7,6};
        selSort(n);
    }
}
