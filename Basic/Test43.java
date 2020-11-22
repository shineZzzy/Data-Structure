package 实验报告;

import java.util.Scanner;

/**
 * 打印用“*”组成的带空格直角三角形图案。
 * 多组输入，一个整数（2~20），
 * 表示直角三角形直角边的长度，
 * 即“*”的数量，也表示输出行数。
 */
public class Test43 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int a=scan.nextInt();
            int count=0;
            for(int i=a;i>0;i--) {
                for (int j = 1; j < i; j++) {
                    System.out.print(" ");
                }
                for(int k=0;k<=a-i;k++){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }

    }
}
