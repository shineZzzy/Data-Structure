package 实验报告;

import java.util.Scanner;

//打印用“*”组成的线段图案
public class Test40 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int a=scan.nextInt();
            for(int i=0;i<a;i++){
                System.out.print("*");
            }
        }
        System.out.println();
    }
}
