package 实验报告;

import java.util.Scanner;

//判断人体健康情况。
public class Test20 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String[] str=s.split(" ");
        double weight=Double.parseDouble(str[0]);
        double height=Double.parseDouble(str[1])/100;
        double BIM=weight/(height*height);
        if(BIM>18.5 &&BIM<23.9){
            System.out.println("Normal");
        }else {
            System.out.println("Abnormal");
        }
    }
}
