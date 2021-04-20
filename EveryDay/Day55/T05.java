package LeetCode.Top100;

/**
 * 最长回文子串
 * 方法：暴力查找、中心扩散
 * 暴力查找：不到截取字符串判断是否为回文串，如果是则记录起始下标和长度，是最大长度时，截取片段返回
 * 中心扩散：以每一个字符为中心，向边缘扩散，找最长回文串。
 * 记录起始下标和长度，截取字符串对应位置返回。
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class T05 {
    //超时
    public static String longestPalindrome(String s) {
        int max=0;
        int start=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s,i,j)){
                    if ((j-i+1)>max){
                        start=i;
                        max=j-i+1;
                    }
                }
            }
        }
        return s.substring(start,start+max);
    }
    public static boolean isPalindrome(String s,int i,int j){
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String longestPalindrome1(String s) {
        if (s.length()<2){
            return s;
        }
        int max=0;
        int start=0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.length()-i)<max/2){
                break;
            }
            int left=i;
            int right=i;

            //看是否连续重复，重复就跳下一个
            while (right<s.length()-1 && s.charAt(right+1)==s.charAt(right)){
                right++;
                i=right;
            }
            //扩散：看当前字符前后是否构成回文串，是，则再扩大范围判断
            while (right<s.length()-1 && left>0 && s.charAt(right+1)==s.charAt(left-1)){
                left--;
                right++;
            }
            //计算回文串长度，记录起始下标
            if ((right-left+1)>max){
                start=left;
                max=right-left+1;
            }
        }
        return s.substring(start,start+max);
    }

    public static void main(String[] args) {
        String s="aaabaaaa";
        String res=longestPalindrome1(s);
        System.out.println(res);
    }
}
