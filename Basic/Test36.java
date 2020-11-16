package 实验报告;
//从键盘输入a, b, c的值，
//编程计算并输出一元二次方程ax2 + bx + c = 0的根，
//当a = 0时，输出“Not quadratic equation”，
//当a ≠ 0时，根据△ = b2 - 4*a*c的三种情况计算并输出方程的根。

import java.util.Scanner;

public class Test36 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        double x1=0;
        double x2=0;
        while (scan.hasNext()){
            String s=scan.nextLine();
            String[] str=s.split(" ");
            double a=Double.parseDouble(str[0]);
            double b=Double.parseDouble(str[1]);
            double c=Double.parseDouble(str[2]);
            if(a==0){
                System.out.println("Not quadratic equation");
            }else {
                double dit=b*b-(4*a*c);
                if(dit==0){
                    x1=x2=-b/2/a;
                    System.out.printf("%.2f",x1);
                    System.out.println();
                }else if(dit>0){
                    x1=(-b-Math.sqrt(dit))/2/a;
                    x2=(-b+Math.sqrt(dit))/2/a;
                    System.out.printf("x1=%.2f;x2=%.2f",x1,x2);
                    System.out.println();
                }else {
                    double shi=-b/(2*a);
                    double xu=Math.sqrt(dit) / (2*a);
                    System.out.printf("x1=%.2f-%.2f;x2=%.2f+%.2f",shi,xu,shi,xu);
                }
            }

        }
    }
}
