package 实验报告;

import java.util.Scanner;

//KiKi想知道他的考试成绩是否完美，请帮他判断。
//从键盘输入一个整数表示的成绩，编程判断成绩是否在90~100之间
//如果是则输出“Perfect”。
public class Test26 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        if(n>90 && n<100){
            System.out.println("Perfect");
        }
    }
}
