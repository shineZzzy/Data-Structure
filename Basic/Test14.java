package 实验报告;

import java.util.Scanner;

//实现字母的大小写转换。多组输入输出。
public class Test14 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String[] s1=s.split("\n");
        String s2=s1[0].toLowerCase();
        String s3=s1[1].toLowerCase();
        System.out.println(s3);
        System.out.println(s2);
    }
}
