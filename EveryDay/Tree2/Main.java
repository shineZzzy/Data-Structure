package LeetCode.Tree2;

import java.util.Arrays;

public class Main {
//    public int[][] merge(int[][] intervals) {
//
//    }


    public static int[] merge0(int[] a, int[] b){

        int[] res=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i]=a[i];
        }
        for (int i = 0; i < res.length; i++) {
            int k=res[i];
            int j;
            for (j = 0; j < b.length; j++) {
                if (b[j]>=k){
                    res[i+1]=b[j];
                }else {
                    break;
                }
            }
        }
        return res;
    }
    public static int[] merge1(int[] a, int[] b){

        if (a[0]<b[0]  && a[1]<b[1]){
            for (int i = 0; i < a.length; i++) {
                a[i++]=b[i];
            }
            return a;
        }
        int[] res=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i]=a[i];
        }
        for (int i = 0; i < res.length; i++) {
            if (a[i]<b[i]){
                return res;
            }
//            int k=res[i];
//            int j;
//            for (j = 0; j < b.length; j++) {
//                if (b[j]>=k){
//                    res[i+1]=b[j];
//                }else {
//                    break;
//                }
//            }
        }
        return res;
    }


    public static void main(String[] args) {
//        int[][] a={{1,3},{2,6}};
        int[] a={1,3};
        int[] b={4,6};
        int[] res=merge1(a,b);
//        int[][] res= merge(a);
        System.out.println(Arrays.toString(res));
    }

    private static int[][] merge(int[][] a) {
        Arrays.sort(a);

        for (int i = 0; i < a[0].length; i++) {
            int start=a[i][0];
            int end=a[0][i];

        }
        return a;
    }
}
