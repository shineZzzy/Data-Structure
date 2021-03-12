package EveryDay.Mar.Day3;

import java.util.Arrays;

public class printString2 {
    public static int[] arrayPrint(int[][] arr, int n) {
        int[] res=new int[n*n];
        int index=0;
        int temp=0;
        for (int j = n-1; j>=0 ; j--) {
            temp=j;
            for (int i = 0; i <n-j ; i++) {
                res[index++]=arr[i][temp++];
            }
        }

        for (int i = 1; i <n ; i++) {
            temp=i;
            for (int j = 0; j <n-i ; j++) {
                res[index++]=arr[temp++][j];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int n=4;
        int[] res=arrayPrint(a,n);
        System.out.println(Arrays.toString(res));

    }
}
