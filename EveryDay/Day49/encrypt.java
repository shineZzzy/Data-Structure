package EveryDay.Mar.Day6;

import java.util.Scanner;

/**
 * 3-12字符串加解密
 * 1、对输入的字符串进行加解密，并输出。
 * 2、加密方法为：
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * 其他字符不做变化。
 * 3、解密方法为加密的逆过程。
 *
 * 用了个好笨的方法......
 * 链接：https://www.nowcoder.com/questionTerminal/2aa32b378a024755a3f251e75cbf233a
 */
public class encrypt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String enStr=sc.nextLine();
            String unEnStr=sc.nextLine();
            getEnStr(enStr);
            getUnEnStr(unEnStr);
        }
    }


    //加密
    private static void getEnStr(String enStr) {
        StringBuilder sb=new StringBuilder();
        char[] c=enStr.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (Character.isUpperCase(c[i])){
                if (c[i]=='Z'){
                    sb.append('a');
                }else {
                   sb.append(Character.toLowerCase((char) (c[i] + 1)));
                }
            }else if(Character.isLowerCase(c[i])){
                if (c[i]=='z'){
                    sb.append('A');
                }else {
                    sb.append(Character.toUpperCase((char) (c[i] + 1)));
                }
            } else if (Character.isDigit(c[i])){
                if (c[i]=='9'){
                    sb.append('0');
                }else {
                    sb.append((char) (c[i]+1));
                }
            }
        }
        System.out.println(sb.toString());
    }

    //解密
    private static void getUnEnStr(String unEnStr) {
        char[] c=unEnStr.toCharArray();
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < c.length; i++) {
            if (Character.isUpperCase(c[i])){
                if (c[i]=='A'){
                    sb.append('z');
                }else {
                    sb.append(Character.toLowerCase((char) (c[i] - 1)));
                }
            }else if(Character.isLowerCase(c[i])){
                if (c[i]=='a'){
                    sb.append('Z');
                }else {
                    sb.append(Character.toUpperCase((char) (c[i] - 1)));
                }
            } else if (Character.isDigit(c[i])){
                if (c[i]=='0'){
                    sb.append('9');
                }else {
                    sb.append((char) (c[i]-1));
                }
            }
        }
        System.out.println(sb.toString());

    }
}
