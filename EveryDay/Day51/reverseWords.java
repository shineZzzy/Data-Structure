package EveryDay.Mar.Day8;

import java.util.Scanner;

/**
 * 单词倒排
 * 注意：可能存在非字母的字符，转化为空格
 * 链接：https://www.nowcoder.com/questionTerminal/81544a4989df4109b33c2d65037c5836
 */
public class reverseWords {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            getWords(s);
        }
    }

    private static void getWords(String s) {
        char[] c=s.toCharArray();
        s=isHaveSpaceMark(c);
        String[] str=s.split(" ");
        String[] res=reverseStr(str);
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < res.length; i++) {
//            if (i!=res.length-1){
//                System.out.print(res[i]+" ");
//            }else {
//                System.out.print(res[i]);
//            }

            sb.append(res[i]+" ");
        }
        System.out.println(sb.toString().trim());

    }

    private static String[] reverseStr(String[] str) {
        int i=0;
        int j=str.length-1;
        while (i<j){
            String temp=str[i];
            str[i]=str[j];
            str[j]=temp;
            i++;
            j--;
        }
        return str;

    }

    private static String isHaveSpaceMark(char[] c) {
        for (int i = 0; i < c.length; i++) {
            if (!Character.isLetter(c[i])){
                c[i]=' ';
            }
        }
        return String.valueOf(c);
    }

}
