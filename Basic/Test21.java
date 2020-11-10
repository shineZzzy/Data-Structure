package 实验报告;

import java.util.Scanner;

//求KiKi最终所花的钱数
public class Test21 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String[] str=s.split(" ");
        double money=Double.parseDouble(str[0]);
        int Month=Integer.parseInt(str[1]);
        int Day=Integer.parseInt(str[2]);
        int discount=Integer.parseInt(str[3]);
        if(Month==11 && Day==11 || Month==12&&Day==12){
            if(Month==11 && Day==11){
                money= 0.7*money;
            }else {
                money= 0.8*money;
            }
            if(discount==1) {
                money=money -50>=0 ? money-50: 0;
            }
        }
        System.out.printf("%.2f",money);
    }
}
