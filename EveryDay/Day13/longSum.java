package Day13;

import java.util.Scanner;

public class longSum {
    public static String Add(String a,String b){
        long a1=Integer.parseInt(a);
        long b1=Integer.parseInt(b);
        long sum=a1+b1;
        String r=String.valueOf(sum);
        return r;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String a=s.nextLine();
        String b=s.nextLine();
        System.out.println(Add(a, b));
    }
}
