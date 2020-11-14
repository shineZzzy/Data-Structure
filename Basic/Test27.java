package 实验报告;

import java.util.Scanner;

/**
 * 从键盘任意输入一个整数表示的分数
 * 编程判断该分数是否在及格范围内，
 * 如果及格，即：分数大于等于60分，
 * 是输出“Pass”，否则，输出“Fail”。
 */

public class Test27 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            int n=scan.nextInt();
            if (n >= 60) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
        }
    }
}
