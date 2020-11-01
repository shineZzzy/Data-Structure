package Sort;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Arrays;
import java.util.Random;

public class Sort3 {
    public static void swap(long[] array,int i,int p){
        long t=array[i];
        array[i]=array[p];
        array[p]=t;
    }
    public static void bubbleSort(long[] array){
        //排序次数
        for(int i=0;i<array.length-1;i++){
            //假设排序前数组已经有序
            boolean isSorted=true;
            for (int j=0;j<array.length-i-1;j++) {
                if (array[j] > array[j + 1]) {
                    //如果 j>j+1 较大值沉底
                    long t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;

                    isSorted = false;
                }
            }
                if (isSorted){
                    break;
                }
            }
    }
    public static void selectSort(long[] array){
        //1.排序次数
        for(int i=0;i<array.length-1;i++){
//            long max=array[i];
            int maxIndex=0;//定义最大数的下标！
            //无序[0,arr.len-i)
            //有序[arr.len-i,arr.len)
            for (int j=1;j<array.length-i;j++){
                //遍历找max
//                if(max<array[j]){
//                    max=array[j];
//                }else{
//                    break;
//                }
                if(array[j]>array[maxIndex]){
                    maxIndex=j;//new 最大数下标
                }
                //找到了，和无序最后一个元素交换
                //无序区间最后一个元素下标为：arr.len-i-1
                swap(array,maxIndex,array.length-i-1);
            }
        }



    }


    public static void main(String[] args) {
        long[] array=new long[10];
        Random random=new Random(20201021);
        //将随机数放进数组中
        for(int i=0;i<10;i++){
            array[i]=random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
