package 实验报告;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

//一年约有3.156×107s，要求输入您的年龄，显示该年龄合多少秒。
public class Test7 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入你的年龄：");
        long age=scan.nextLong();
        long year=31560000;
        long s=age*year;
        System.out.println(s);

    }
}
