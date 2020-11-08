package 实验报告;

import java.util.Scanner;

//给定秒数seconds (0< seconds < 100,000,000)
//把秒转化成小时、分钟和秒
public class Test8 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        long s=scan.nextLong();
        long h=s/3600;
        s=s%3600;
        long m=s/60;
        s=s%60;
        System.out.println(h+" "+m+" "+s);

        //2.以string 类型输入，转化为int型
    }
}
