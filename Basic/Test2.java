package 实验报告;

//输入一个人的出生日期（包括年月日），将该生日中的年、月、日分别输出

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String s1=s.substring(0,4);
        String s2=s.substring(4,6);
        String s3=s.substring(6,8);
        System.out.println("Year="+s1);
        System.out.println("Month="+s2);
        System.out.println("Day="+s3);
    }
}
