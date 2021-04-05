package DataStructure.Test.leetcode.isBracket;

import java.util.Stack;

public class isTrue1 {
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()) {
                if (s.charAt(i) == ')' && stack.peek() == '(' || s.charAt(i) == ']' && stack.peek() == '[' || s.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
//
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1="([{}])";
        String s="(])";
        String s2="([)]";
        String s3="(){}}{";

        boolean res=isValid(s3);
        System.out.println(res);
    }
}
