package Day7;

import java.util.Scanner;

/**
 * 求A\B最小公倍数
 * 能被A.B整除的最小整数值
 */
public class minN {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int A=scan.nextInt();
            int B=scan.nextInt();
            int minC=0;
            int maxC=0;
            if(A>B){
                int t=A;
                A=B;
                B=t;
            }
            if( B%A==0){
                System.out.println("0");
            }
            //求最大公约数
            int a=A;
            int b=B;
            while (b!=0){
                    maxC = a;
                    a = b;
                    b = maxC % b;
            }
//            System.out.println(a);
//            System.out.println(B);
//            //求最小公倍数
            minC=(A*B)/a;
            System.out.println(minC);
        }
    }

}
