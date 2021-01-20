package Test.T0119;

import java.util.Arrays;
import java.util.Scanner;

public class gift {
    public static int getValue(int[] gifts, int n) {
        // write code here
        int count=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(gifts[i]==gifts[j]){
                    count++;
                }
            }
            if(count>(n/2)){
                return gifts[i];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(",");
        int n=sc.nextInt();
        int[] gift=new int[n];
        for (int i=0;i<s.length;i++){
            gift[i]=Integer.parseInt(s[i]);
        }
        System.out.println(Arrays.toString(gift));
        System.out.println(getValue(gift, n));
    }
}
