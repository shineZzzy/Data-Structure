package Test.Day41;

import java.util.Scanner;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。
 * 返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 */
public class findLast {
    public static int lengthOfLastWord(String s){
        int end=s.length()-1;
        while (end>0 && s.charAt(end)==' '){
            end--;
        }
        if (end<0){
            return 0;
        }
        int start=end;
        while (start>0 && s.charAt(start)!=' '){
            start--;
        }
        return end-start;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int res=lengthOfLastWord(s);
        System.out.println(res);
    }
}
