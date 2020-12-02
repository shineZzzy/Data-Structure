package Day8;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class findMinK {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()) {
            String s1=scan.nextLine();
            String s2=s1.substring(0,s1.length()-2);
            String[] s3=s1.split(" ");
            int n=Integer.parseInt(s3[s3.length-1]);

            System.out.println(s2);
            String[] s=s2.split(" ");

            int[] a = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            Stack stack=new Stack();
            Arrays.sort(a);
//            System.out.println(Arrays.toString(a));
            for(int j=a.length-1;j>=0;j--){
                stack.push(a[j]);
            }
//            System.out.println(stack);
            int k=0;
            while (k<n){
                System.out.print(stack.pop()+" ");
                k++;
            }
        }
    }
}

//3 9 6 8 -10 7 -11 19 30 12 23