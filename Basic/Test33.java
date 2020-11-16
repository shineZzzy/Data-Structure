package 实验报告;

import java.util.Scanner;

//KiKi最近学习了信号与系统课程，
//这门课里有一个非常有趣的函数，
//单位阶跃函数，其中一种定义方式为：
//现在试求单位冲激函数在时域t上的值
public class Test33 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String s=scan.nextLine();
            int a=Integer.parseInt(s);
            if(a>0){
                System.out.println("1");
            }else if(a==0){
                System.out.println("1/2");
            }else {
                System.out.println("0");
            }
        }
    }
}
