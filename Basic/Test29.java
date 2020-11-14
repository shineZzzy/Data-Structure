package 实验报告;

import java.util.Scanner;

/**
 * KiKi参加了语文、数学、外语的考试，
 * 请帮他判断三科中的最高分。
 * 从键盘任意输入三个整数表示的分数，
 * 编程判断其中的最高分。
 */
public class Test29 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()) {
            String s = scan.nextLine();
            String[] str = s.split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            int max = a;
            if(max<b){
                max=b;
            }else if(max<c){
                max=c;
            }else {
                max=a;
            }
            System.out.println(max);
            scan.close();
        }
    }
}
