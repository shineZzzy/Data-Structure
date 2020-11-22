package 实验报告;

import java.util.Scanner;

/**
 * 多组输入，一个整数（2~20），
 * 表示翻转直角三角形直角边的长度，
 * 即“*”的数量，也表示输出行数。
 */
public class Test42 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int a=scan.nextInt();
            for(int i=a;i>0;i--){
                for(int j=0;j<i;j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
}
