package Sort;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class test {
//    public static int[] toTransfer10(long n){
//        Deque<Integer> stack=new LinkedList<>();
//        while(n>0){
//            int res=(int)(n%10);
//            stack.push(res);
//            n=n/10;
//        }
//        int[] array=new int[stack.size()];
//        for(int i=0;i<array.length;i++){
//            array[i]=stack.pop();
//        }
//        return array;
//    }
//
//    public static void main(String[] args) {
////        long a=20201018;
//        Scanner scan=new Scanner(System.in);
//        while(scan.hasNextLong()){
//            long n=scan.nextLong();
//            System.out.println(Arrays.toString(toTransfer10(n)));
//
//        }
//    }
    //1.定义一个栈
    //2.将long n进行计算逐个得出，压入栈中
    //3.定义一个数组
    //4.将数值出栈，存入数组中，打印出来
    public static int[] getNum(long n){
        Deque<Integer>stack=new LinkedList<>();
        while(n>0){
            int res=(int)(n%10);
            stack.push(res);
            n=n/10;
        }
        int[] a=new int[stack.size()];
        for(int i=0;i<a.length;i++){
            a[i]=stack.pop();
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextLong()){
            long n=scan.nextLong();
            System.out.println(Arrays.toString(getNum(n)));
        }
    }
}
