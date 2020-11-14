package 实验报告;

import java.util.Scanner;

/**
 * 从键盘任意输入一个整数（范围-231~231-1），
 * 编程判断它的奇偶性。
 */
public class Test28 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int n=scan.nextInt();
            if(n%2==0){
                System.out.println("Even");
            }else {
                System.out.println("Odd");
            }
        }
    }

}
