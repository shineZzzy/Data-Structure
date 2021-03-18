package EveryDay.Mar.Day8;
import java.util.Scanner;

/**
 * 骆驼命名法
 * 注意：需要将连字符去掉，并将其下一个字符转为大写
 * 链接：https://www.nowcoder.com/questionTerminal/aed1c7bbc2604e7c9661a2348b0541b8
 */

public class ReName {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            getName(s);
        }
    }

    private static void getName(String s) {
        char[] c=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <c.length ; i++) {
            if (c[i]=='_'){
                sb.append(Character.toUpperCase(c[i+1]));
                i++;
            }else {
                sb.append(c[i]);
            }

        }
        System.out.println(sb.toString());

    }
}
