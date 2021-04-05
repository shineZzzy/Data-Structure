package DataStructure.Test.leetcode.isBracket;
import java.util.Stack;

/**
 * 和栈顶元素进行匹配
 * false：遍历完栈不为空、栈空字符串还有右括号、左右括号位置不匹配
 * https://leetcode-cn.com/problems/valid-parentheses/
 */

public class isTrue {
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else if(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}'){
                if (stack.isEmpty()){
                    return false;
                }
                char c=stack.pop();
                if (!compareChar(c,s.charAt(i))){
                    return false;
                }
            }
        }
//
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    private static boolean compareChar(char c, char s) {

        if ((c=='(') && s==')' || (c=='[') && s==']'|| (c=='{') && s=='}'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1="([12{1}34])";
        String s="(])";
        String s2="([)]";
        String s3="(){}}{";

        boolean res=isValid(s3);
        System.out.println(res);
    }
}
