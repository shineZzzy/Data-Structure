package Sloution.百度;

import java.util.Scanner;
import java.util.Stack;

/**
 * 括号匹配
 * 思路：栈的思想
 * 当前字符为左大括号、左中括号、左小括号时，入栈
 * 当前字符非入栈字符时，与栈的元素匹配，如果与栈顶匹配，则栈顶元素出栈...
 * 反思：思路正确，但是在入栈的时候条件设置的过于宽泛，失败....
 *      会但得写出来啊！
 * 链接：https://leetcode-cn.com/problems/valid-parentheses/
 */
public class T20 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            boolean res=isRight(str);
            System.out.println(res);
        }
    }

    private static boolean isRight(String str) {
        int len=str.length();
        if (len==0){
            return true;
        }
        char[] ch=str.toCharArray();
        Stack<Character> stack=new Stack<>();

       int i=0;
       while (i<ch.length){
           if(stack.isEmpty() || ch[i]=='(' || ch[i]=='['|| ch[i]=='{'){
               stack.push(ch[i]);
           }else {
               char c = stack.peek();
               if (c == '(') {
                   ch[i] = ')';
                   stack.pop();
               } else if (c == '{') {
                   ch[i] = '}';
                   stack.pop();
               } else if (c=='['){
                   ch[i]=']';
                   stack.pop();
               }
           }
           i++;


       }
        return i == ch.length && stack.isEmpty();
    }
}
