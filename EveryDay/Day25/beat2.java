package Test.Day23;

import java.util.Scanner;

public class beat2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        while (sc.hasNext()){
            int n=sc.nextInt();
            int a=sc.nextInt();
            int res=0;

            for (int i = 0; i <n; i++) {
                int x=sc.nextInt();
                res=count(n,a,x);
            }
            System.out.println(res);
        }
    }

    private static int count(int n, int a, int x) {
        int c=a;
        if(x<= c){
            c +=x;
        }else {
            c +=getN(c,x);
        }
        return c;
    }
    private static int getN(int c, int x) {
        if(x<c){
            int t=x;
            x=c;
            c=t;
        }

        if(x%c==0){
            return c;
        }else {
            return getN(x%c,c);
        }

//        int n=1;
//        for (int i = 1; i <=c; i++) {
//            if(c%i==0 && x%i==0){
//                n=i;
//            }
//        }
//        return n;
    }
}
