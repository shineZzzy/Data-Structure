package Test.Day41;

import java.util.Scanner;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 从后往前遍历，遇见空格就结束
 */
public class findLast2 {
    public static int lengthOfLastWord1(String s) {
        if(s == null || s.length() == 0) return 0;
        int count=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)==' '){
                //可能最后一个单词为空格
                if (count == 0){
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }


    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                count++;
            }else {
                if(count == 0) {
                    continue;
                }
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int res=lengthOfLastWord(s);
        System.out.println(res);
    }
}
