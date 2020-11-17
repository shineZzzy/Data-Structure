package 实验报告;

import java.util.Scanner;

//KiKi想获得某年某月有多少天，
//输入年份和月份，计算这一年这个月有多少天。
public class Test37 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String[] str=scan.nextLine().split(" ");
            int year=Integer.parseInt(str[0]);
            int month=Integer.parseInt(str[1]);
            int[] a={31,0,31,30,31,30,31,31,31,31,30,31};
            //仅2月有差
            if(year%4==0 &&(year%100!=0)||(year%400==0)){
                a[1]=29;
            }else {
                a[1]=28;
            }
            System.out.println(a[month-1]);
        }

    }

}
