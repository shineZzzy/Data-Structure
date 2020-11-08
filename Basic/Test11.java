package 实验报告;

import java.util.Scanner;

//计算BMI指数（身体质量指数）
public class Test11 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String[] s1=s.split(" ");
        double weight=Double.parseDouble(s1[0]);
        double height=Double.parseDouble(s1[1])/100;
        double BIM=weight/(height*height);
        System.out.printf("%.2f",BIM);
    }

}
