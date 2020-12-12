package Day16;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 思路：
 * 打算用一个循环处理卡牌信息
 * 即，得知n后，输入卡牌信息，再对卡牌洗牌
 */
public class test2 {
    public static void shuffle(int[] a){
        int key=partition(a,0,a.length-1);




    }
    public static int partition(int[] a,int lowIndex,int highIndex){
        int lI=lowIndex;
        int rI=highIndex;
        int key=a[lI];
        while (lI<rI){
            while (lI<rI && a[rI]>=key){
                rI--;
            }
            while (lI<rI && a[lI]<=key){
                lI++;
            }
            swap(a,lI,rI);
        }
        swap(a,lowIndex,lI);
        return lI;
    }

    private static void swap(int[] a, int l, int r) {
        int temp=a[l];
        a[l]=a[r];
        a[r]=temp;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int N=scan.nextInt();
            int n=scan.nextInt();
            int k=scan.nextInt();
            int[] a=new int[2*n];
            for (int i=0;i<a.length;i++){
                a[i]=scan.nextInt();
            }
            System.out.println(Arrays.toString(a));

        }
    }
}
