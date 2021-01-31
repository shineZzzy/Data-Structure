package Test.Day30;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 大整数排序
 */
public class sort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            BigInteger[] m = new BigInteger[n];
            int i;
            for (i = 0; i <n; i++) {
                m[i]=sc.nextBigInteger();
            }
            Arrays.sort(m);
            for (BigInteger j:m) {
                System.out.println(j);
            }
        }
    }
//            System.out.println(Arrays.toString(m));
//    private static void getSort(BigInteger[] m) {
//
//    }
}
