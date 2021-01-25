package Test.Day23;

import java.util.Scanner;

public class beat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNext()){
            int n=sc.nextInt();
            int a=sc.nextInt();
            int[] x =new int[n];
            for (int i = 0; i< n; i++){
                x[i]=sc.nextInt();
            }
            int res=count(n, a, x);
            System.out.println(res);
        }
    }
    // 5 20
// 30 20 15 40 100
    private static int  count(int n, int a, int[] x) {
        int c=a;
        for (int i = 0; i <x.length ; i++) {

            //错误原因：每次都与a比，应该是与当前值比较
            if(x[i]<=c){
                c +=x[i];
            }else{
                //公约数
                c +=getN(c,x[i]);
            }
        }
        return c;
    }
    private static int getN(int c, int x) {
        if(x%c==0){
            return c;
        }
        else {
            return getN(x%c,c);
        }
//        if (x < c) {
//            int t = x;
//            x = c;
//            c = t;
//        }
//
//        if (x % c == 0) {
//            return c;
//        } else {
//            return getN(c, x % c);
//        }
    }

//    private static int getN(int c, int x) {
//        int n=1;
//        for (int i = 1; i <=c; i++) {
//            if(c%i==0 && x%i==0){
//                n=i;
//            }
//        }
//        return n;
//    }
}


//3 50
//50 105 200
//5 20
//30 20 15 40 100