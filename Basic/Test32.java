package 实验报告;

import java.util.Scanner;

//KiKi想知道从键盘输入的两个数的大小关系
public class Test32 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String s=scan.nextLine();
            String[] str=s.split(" ");
            int a=Integer.parseInt(str[0]);
            int b=Integer.parseInt(str[1]);
            if(a>b){
                System.out.println(a+">"+b);
            }else if(a<b){
                System.out.println(a+"<"+b);
            }else {
                System.out.println(a+"="+b);
            }
        }
    }
}
