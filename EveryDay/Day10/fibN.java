package Day10;

import java.util.Scanner;

/**
 * 求一个数n成为fib数的最小步数
 * 思路：
 * 求n与其最近的两个fib数的最小差值
 */
public class fibN {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int f1=0;
        int f2=1;
        int f3=0;
        while (f2<n){
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        if(Math.abs(f2-n)>Math.abs(f1-n)){
            System.out.println(Math.abs(f1-n));
        }else {
            System.out.println(Math.abs(f2-n));
        }
    }
}
