package Test.Day32.Day33;

import java.util.Scanner;

public class GoUpstairs {
    public static int countWays(int n) {
        // write code here
//        if(n==1){
//            return 1;
//        }else if(n==2){
//            return 2;
//        }else if(n==3){
//            return 4;
//        }else {
//            return countWays(n-1)+countWays(n-2)+countWays(n-3);
//        }
        if(n==0 || n==1 || n==2){
            return n;
        }
        if(n==3){
            return 4;
        }
        int f1=1,f2=2,f3=4,f4;
        while (n>=4){
            f4=((f1+f2)%1000000007+f3)%1000000007;
            f1=f2;
            f2=f3;
            f3=f4;
            n--;
        }
//        return ((countWays(n-1)+countWays(n-2)%100000007)+countWays(n-3) )%100000007;
        return f3;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int res=countWays(n);
            System.out.println(res);
        }
    }
}
