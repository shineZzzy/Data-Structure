package 实验报告;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

//根据给出的三角形3条边a, b, c（0 < a, b, c < 100,000）
//计算三角形的周长和面积。
public class Test12 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String[] s1=s.split(" ");
        double a=Double.parseDouble(s1[0]);
        double b=Double.parseDouble(s1[1]);
        double c=Double.parseDouble(s1[2]);

        double p = (a + b + c) / 2;
        double C = a + b + c;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.printf("circumference=%.2f area=%.2f",C,area);
        //int 类型会有损失
    }
}
