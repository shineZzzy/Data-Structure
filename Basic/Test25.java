package 实验报告;

import java.util.Scanner;

//输入一个整数表示一个人的智商
//如果大于等于140，则表明他是一个天才
//输出“Genius”。
public class Test25 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        if(n>=140){
            System.out.println("Genius");
        }
    }
}
