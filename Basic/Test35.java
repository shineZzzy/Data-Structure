package 实验报告;

import java.util.Scanner;

//在计算BMI（BodyMassIndex ，身体质量指数）
//的案例基础上，
//判断人体胖瘦程度。
public class Test35 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String s=scan.nextLine();
            String[] str=s.split(" ");
            double weight=Double.parseDouble(str[0]);
            double height=Double.parseDouble(str[1]);
            double BIM=weight/(height*height);
            if(BIM<18.5){
                System.out.println("Underweight");
            }else if(BIM>=18.5 && BIM<=23.9){
                System.out.println("Normal");
            }else if(BIM>23.9 && BIM<=27.9){
                System.out.println("Overweight");
            }else {
                System.out.println("Obese");
            }
        }
    }
}
