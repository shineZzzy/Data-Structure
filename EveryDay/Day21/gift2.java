package Test.T0119;

import java.util.Arrays;
import java.util.Scanner;

public class gift2 {
    public static int getValue(int[] gifts, int n) {
        // write code here
        int count=0;
        int key=0;
        if(n%2==0){
            key=gifts[n/2];
        }else {
            key=gifts[(n+1)/2];
        }
        Arrays.sort(gifts);
        for (int i=0;i<gifts.length;i++){
            if(gifts[i]==key){
                count++;
            }
        }
        return count>=n/2?key:0;
//        if (count>=(n/2)){
//            return key;
//        }else {
//            return 0;
//        }
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
