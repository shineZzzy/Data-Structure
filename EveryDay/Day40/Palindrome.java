package Test.Day40;

/**
 * 回文串
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * 方法一：字符串遍历
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 */
public class Palindrome {
    public static boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        int i=0;
        //最后一个元素下标应该是长度-1！
        int j=s.length()-1;
        while (i<j){
            if (s.charAt(i)==s.charAt(j)){
                return true;
            }
            i++;
            j--;
        }
        return false;
    }

    public static void main(String[] args) {
        int x=1001;
        boolean res=isPalindrome(x);
        System.out.println(res);
    }
}
