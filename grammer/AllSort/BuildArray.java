package AllSort;

import java.util.Arrays;
import java.util.Random;

public class BuildArray {
    //测试用例
    //1.随机乱序
    //2.完全有序
    //3.有序逆序
    //4.完全相等
    public static long[] 随机数组(){
        Random random=new Random(20201018);//随机种子
        long[] array=new long[10];
        for(int i=0;i<10;i++){
            array[i]=random.nextInt(100);
        }
        return array;
    }
    public static long[] 完全有序数组(){
        long[] array=new long[10];
        Arrays.sort(array);
        return array;
    }
    public static void swap(long[] arr,int i,int j){
        long t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    public static long[] 完全逆序数组(){
        long[] array=完全有序数组();
        swap(array,0,9);
        swap(array,1,8);
        swap(array,2,7);
        swap(array,3,6);
        swap(array,4,5);
        return array;
    }
    public static long[] 完全相等数组(){
        long[] array=new long[10];
        for(int i=0;i<10;i++){
            array[i]=9;
        }
        return array;
    }

}
