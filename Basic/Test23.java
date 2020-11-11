package 实验报告;

import java.util.Scanner;

//从键盘输入n个学生成绩（不超过40个），输出每组排在前五高的成绩。
//第一行输入一个整数，表示n个学生（>=5），第二行输入n个学生成绩（整数表示，范围0~100）
public class Test23 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        String s=scan.nextLine();
        String[] str=s.split(" ");
        int[] sco=new int[Integer.parseInt(str[n])];
        sco[0]=Integer.parseInt(str[0]);
        for(int i=0;i<n;i++){
            sco[i]=Integer.parseInt(str[i]);
        }


        int a=Integer.parseInt(str[0]);


    }
}
