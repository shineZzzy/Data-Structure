package 实验报告;

import java.util.Scanner;

//输入一个字符，输出该字符相应的ASCII码。
public class Test3 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        char c=scan.next().charAt(0);
//        int a=Integer.valueOf(c);
        if(c>'0' && c <'9'){
            System.out.println(c-'0');
        }else {
            System.out.println(c-'A');
        }
//        System.out.println(a);
    }
}
