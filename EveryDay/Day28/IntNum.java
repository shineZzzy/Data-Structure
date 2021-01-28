package Test.Day28;

import java.util.Scanner;

/**
 * 守形数是这样一种整数，它的平方的低位部分等于它本身。
 * 比如25的平方是625，低位部分是25，因此25是一个守形数。
 * 编一个程序，判断N是否为守形数。
 */
public class IntNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            isKeepShape(n);
        }
    }

    private static void isKeepShape(int n) {
        int m= n*n;
        int c=n;
        int count=0;
        while (n>0){
            n /=10;
            count++;
        }
        //625 % 100
        int num= (int) (m % Math.pow(10,count));
        if(c==num){
            System.out.println("Y");
        }else {
            System.out.println("N");
        }

    }
}
