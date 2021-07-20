package LeetCode1.Sort;

import java.util.Arrays;

public class Solution_1 {
    public  static int[] sort_data(int[] list_data) {
        int len=list_data.length;
        if (len==0){
            return null;
        }

        int key=0;
        for (int i = 0; i < len; i++) {
            if (list_data[i]==0){
                int temp=list_data[i];
                for (int j = i-1; j>=key; j--) {
                    list_data[j+1]=list_data[j];
                }
                list_data[key]=temp;
                key++;
            }
        }
        return list_data;
    }

    private static void swap(int[] list_data, int i, int j) {
        int temp=list_data[j];
        list_data[j]=list_data[i];
        list_data[i]=temp;
    }

    public static void main(String[] args) {
        int[] nums={0,3,0,2,1,0,-1};
        System.out.println(Arrays.toString(sort_data(nums)));

    }
}
