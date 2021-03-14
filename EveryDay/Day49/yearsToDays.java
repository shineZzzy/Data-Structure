package EveryDay.Mar.Day6;
import java.util.Scanner;

/**
 * 计算日期到天数的转换
 * 算当前日期到月底的剩余天数，用总年（判断闰平年）天数相减
 * 还是一个很笨很笨的方法......
 * 链接：https://www.nowcoder.com/questionTerminal/769d45d455fe40b385ba32f97e7bcded
 */
public class yearsToDays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int year=sc.nextInt();
            int month=sc.nextInt();
            int day=sc.nextInt();
            getDays(year,month,day);
        }
    }

    private static void getDays(int year, int month, int day) {
        int sumDays=0;
        int d=0;
        int sum=0;
        //先判断是否闰年
        if(year%4==0 && year %100!=0  || year%400==0){
            sumDays=366;
        }else {
            sumDays=365;
        }
        //根据年份对应日期求天数
        switch (month){
            case 1:d=31;
                sum+=d;
            case 2:d=28;
                sum+=d;
            case 3:d=31;
                sum+=d;
            case 4:d=30;
                sum+=d;
            case 5:d=31;
                sum+=d;
            case 6:d=30;
                sum+=d;
            case 7:d=31;
                sum+=d;
            case 8:d=31;
                sum+=d;
            case 9:d=30;
                sum+=d;
            case 10:d=31;
                sum+=d;
            case 11:d=30;
                sum+=d;
            case 12:d=31;
                sum+=d;
        }
        int c=sumDays-(sum-day);
        System.out.println(c);
    }
}
