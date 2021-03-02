package Test.Day45;
import java.util.Stack;

/**
 * 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters/
 */
public class reverse {
    //双指针
//    public static String reverseOnlyLetters(String S) {
//
//    }
    //栈
    public static String reverseOnlyLetters1(String S) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i <S.length() ; i++) {
            //isLetter 判断当前字符是否为字母  isDigit判断是否为数字
            if(Character.isLetter(S.charAt(i))){
                //如果为字母，入栈
                stack.push(S.charAt(i));
            }
        }
        StringBuilder s= new StringBuilder();
        for (int i = 0; i <S.length(); i++) {
            //拼接新字符串
            //如果是字母，取栈中
            if (Character.isLetter(S.charAt(i))){
                s.append(stack.pop());
            }else {
                //不是，取当前元素(即，符号)
                s.append(S.charAt(i));
            }
        }
        return s.toString();
    }


    public static void main(String[] args) {
        String s="a-bC-dEf-ghIj";
        String res=reverseOnlyLetters1(s);
        System.out.println(res);
    }
}
