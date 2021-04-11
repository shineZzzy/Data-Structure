package EveryDay.offer.Sort;

import java.util.Arrays;

public class SortArr {
    public static int[] MySort (int[] arr) {
        // write code here
        int[] res=insertSort(arr);
        return res;
    }
    public static int[] insertSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int key=arr[i+1];
            int j=0;
            for(j=i;j>=0;j--){
                if(arr[j]<=key){
                    break;
                }else{
                    arr[j+1]=arr[j];
                }
            }

            arr[j+1]=key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a={5,2,3,1,4};
        int[] res=MySort(a);
        System.out.println(Arrays.toString(res));
    }
}
