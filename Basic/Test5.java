package 实验报告;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

//给定两个整数a和b (－10,000 < a,b < 10,000)，
//计算a除以b的整数商和余数。
public class Test5 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String[] s1=s.split(" ");
        int a=Integer.parseInt(s1[0]);
        int b=Integer.parseInt(s1[1]);
//        int a=scan.nextInt();
//        int b=scan.nextInt();
        int c=a/b;
        int res=a%b;
        System.out.println(c+" "+res);



    }
}
