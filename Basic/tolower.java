package Java;

import java.util.Scanner;

/**
 * 实现函数 ToLowerCase()，
 * 该函数接收一个字符串参数 str，
 * 并将该字符串中的大写字母转换成小写字母，
 * 之后返回新的字符串
 */
public class tolower {
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(toLowerCase(s));
    }
}
