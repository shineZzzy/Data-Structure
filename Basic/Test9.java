package 实验报告;

import java.util.Scanner;

//依次输入一个学生的3科成绩
//在屏幕上输出该学生的总成绩以及平均成绩
public class Test9 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String[] s1=s.split(" ");
        double a=Double.parseDouble(s1[0]);
        double b=Double.parseDouble(s1[1]);
        double c=Double.parseDouble(s1[2]);

        double sum=a+b+c;
        double avg=sum/3;
        //题目要求：保留小数点后两位！
        System.out.printf("%.2f %.2f",sum,avg);
    }
}
