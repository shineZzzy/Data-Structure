package Sloution.T0929;

/**
 * 字符串
 * 题意：给定一个字符串，可以在字符串前面添加一些字符使其变成回文串，返回操作后的最短字符串
 */
public class T03_3 {
    public static void main(String[] args) {
        String s="aacecaaa";
        String res = shortestPalindrome(s);
        System.out.println(res);
    }
    public static String shortestPalindrome (String s) {
        int len = s.length();
        if (len == 0) {
            return null;
        }
        StringBuilder str=new StringBuilder();
        for (int j = len-1; j >=0 ; j--) {
            str.append(s.charAt(j));
        }

        int i=0;
        while (i<len){
            String inner=str.substring(i);
            String after=s.substring(0, len - i);
            if (inner.equals(after)){
                break;
            }
            i++;
        }
        String res=str.substring(0,i);
        return res+s;
    }
}
