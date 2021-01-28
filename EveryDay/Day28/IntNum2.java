package Test.Day28;

import java.util.Scanner;

/**
 * 守形数是这样一种整数，它的平方的低位部分等于它本身。
 * 比如25的平方是625，低位部分是25，因此25是一个守形数。
 * 编一个程序，判断N是否为守形数。
 * 牛客链接：https://www.nowcoder.com/questionTerminal/99e403f8342b4d0e82f1c1395ba62d7b
 */
public class IntNum2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            isKeepShape(n);
        }
    }

    private static void isKeepShape(int n) {
        String s1=String.valueOf(n);
        String s2=String.valueOf(n*n);
        if (s2.endsWith(s1)){
            System.out.println("Yes!");
        }else {
            System.out.println("No!");
        }
    }
}
