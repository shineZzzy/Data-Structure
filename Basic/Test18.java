package 实验报告;

import java.util.Scanner;

//从键盘输入5个学生的成绩（整数）
//求他们的平均成绩（浮点数，保留一位小数）。
public class Test18 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String[] str=s.split(" ");
        int a=Integer.parseInt(str[0]);
        int b=Integer.parseInt(str[1]);
        int c=Integer.parseInt(str[2]);
        int d=Integer.parseInt(str[3]);
        int e=Integer.parseInt(str[4]);
        double avg=(a+b+c+d+e)/5;
        System.out.printf("%.2f",avg);

    }
}
