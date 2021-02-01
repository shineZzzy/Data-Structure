package Test.Day31;

import java.util.Scanner;

public class error {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            getErrorCount(s);
        }
    }

    private static void getErrorCount(String s) {
        int n=s.indexOf(" ");
        if (n>16){
            String s1=s.substring(16);
            System.out.println(s1);
        }else {
            System.out.println(s);
        }
    }

}
