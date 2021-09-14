package Sloution.T1;

import java.util.Scanner;

/**
 * 删除字符串中的所有相邻重复项
 * 思路：栈（遍历字符串，当前元素与栈顶元素相同，删除栈顶）
 *      此处用stringBuilder元素拼接方式...
 * 问题：只单纯删除相邻元素，是片面的，eg:addcab==cb
 *      因此可以利用栈的先进后出的思想，先存起来：
     *      遇到相同的，删掉(物理上不相邻，逻辑上相邻)
     *      不同的，存起来
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class T1047 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            String res=removeDuplicates(str);
            System.out.println(res);
        }
    }

    private static String removeDuplicates(String str) {
        int len=str.length();
        if(len<=1){
            return str;
        }
        StringBuilder res=new StringBuilder();
        char[] ch=str.toCharArray();
        for (char c : ch) {
            //栈空 || 栈顶元素与当前元素不同 入栈
            if (res.length()==0 || res.charAt(res.length()-1)!=c){
                res.append(c);
            }else {
            //栈顶元素与当前元素相同，出栈
                res.deleteCharAt(res.length()-1);
            }
        }
        return res.toString();
    }

}
