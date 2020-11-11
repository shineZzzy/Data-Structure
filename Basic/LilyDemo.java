package 实验报告;

import java.util.Scanner;

//求出 5位数中的所有 Lily Number
//655 = 6 * 55 + 65 * 5
public class LilyDemo {
    public static void main(String[] args) {
        for (int i = 10000; i <= 99999; i++) {
            if ((((i/10000)*(i%10000)) + ((i/1000)*(i%1000)) + ((i/100)*(i%100)) + ((i/10)*(i%10))) == i){
                System.out.print(i+" ");
            }
        }
    }
}
