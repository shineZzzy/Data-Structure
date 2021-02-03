package Test.Day32;

import java.util.Arrays;
import java.util.Scanner;

public class count4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int res=getTwo(n);
            System.out.println(res);
        }
    }

    private static int getTwo(int n) {
        String[] s=new String[n+1];
        int count=0;
        for (int i = 0; i <=n; i++) {
            s[i]=String.valueOf(i);
        }
        System.out.println(Arrays.toString(s));
        for (int i = 0; i <s.length; i++) {
            if (s[i].contains("2")){
                count++;
            }
        }
        return count;
    }
}
