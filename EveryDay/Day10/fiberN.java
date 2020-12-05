package Day10;

import java.util.Scanner;

public class fiberN {
    public static int fibC(int n){
        int f1=0;
        int f2=1;
        int f3=0;
        while (f2<n){
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        if(Math.abs(f2-n)>Math.abs(f1-n)){
            return Math.abs(f1-n);
        }
        return Math.abs(f2-n);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        System.out.println(fibC(n));
    }
}
