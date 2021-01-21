package Test.T0120;

import java.util.Scanner;

public class Ascall {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            ok(s);
        }
    }

    private static void ok(String s) {
        int n=0;
        char c = 0;
        for (int i = 0; i <s.length() ; i++) {
            n=Integer.valueOf(s.charAt(i));
            c=(char) (n+5);
        }
        System.out.println(n);
        System.out.println(c);
    }
}
