package TT;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        int[] nums={7,6,5,4,3,1,2};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public  static void quickSort(int[] arr){
        quickInternal(arr,0,arr.length-1);

    }

    public static void quickInternal(int[] arr,int low,int high){
        int size=high-low+1;
        if (size<=1){
            return;
        }

        int key=partition(arr,low,high);

        quickInternal(arr,low,key-1);
        quickInternal(arr,key+1,high);
    }

    private static int partition(int[] arr, int low, int high) {
        int left=low;
        int right=high;
        int key=arr[left];
        while (left<right){
            while (left<right && arr[right]>=key){
                right--;
            }
            while (left<right && arr[left]<=key){
                left++;
            }

            swap(arr,left,right);
        }
        swap(arr,low,left);
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

}
