package Test.Day30;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            getCheck1(s);
        }
    }

    private static void getCheck1(String s) {
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            String s1=Integer.toBinaryString(s.charAt(i));
            String str=String.format("%07d",Integer.parseInt(s1));
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    count++;
                }
            }
            System.out.println(count % 2 == 0 ? "1" + str : "0" + str);
        }


    }
}
