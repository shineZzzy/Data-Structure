package 实验报告;

import java.util.Scanner;

//KiKi想知道已经给出的三条边a，b，c能否构成三角形，
//如果能构成三角形，
//判断三角形的类型
//(等边三角形、等腰三角形或普通三角形)
public class Test34 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String s=scan.nextLine();
            String[] str=s.split(" ");
            int a=Integer.parseInt(str[0]);
            int b=Integer.parseInt(str[1]);
            int c=Integer.parseInt(str[2]);
            if (a+b>c && a+c>b && b+c>a){
                if(a==b||a==c||b==c){
                    System.out.println("Isosceles triangle!");
                }else if(a==b && b==c){
                    System.out.println("Equilateral triangle!");
                }else {
                    System.out.println("Ordinary triangle!");
                }
            }else {
                System.out.println("Not a triangle!");
            }
        }
    }
}
