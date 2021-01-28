package Test.Day28;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            if (isRepeat(s)){
                System.out.println("Y");
            }else {
                System.out.println("N");
            }
        }
    }

    private static boolean isRepeat(String s) {
        for (int i = 0; i < s.length()-2; i++) {
            String str=s.substring(i,i+3);
            if (s.substring(i+1).contains(str)){
                return false;
            }
        }
        return true;
    }
}


//021Abc9000
//        021Abc9Abc1
//        021ABC9000
//        021$bc9000
