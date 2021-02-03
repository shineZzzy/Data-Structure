package Test.Day32;

import java.util.Scanner;

public class count2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int res=countNumberOf2s(n);
            System.out.println(res);
        }
    }
    public static int countNumberOf2s(int n) {
        int count=0;
//        int[] m=new int[n+1];
//        for (int i = 0; i <m.length; i++) {
//            m[i]=i;
//        }

        for (int i = 0; i <=n; i++) {
            int temp=i;
            while (temp!=0){
                if(temp %10==2){
                    count++;
                }
                temp/=10;
            }
        }
        return count;
    }
}
