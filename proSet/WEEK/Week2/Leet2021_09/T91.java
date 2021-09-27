package Leet2021_09;

/**
 * 解码方法
 * 思路：动规
 *      单独解码
 *      结合解码
 * 链接：https://leetcode-cn.com/problems/decode-ways/
 */
public class T91 {
    public static void main(String[] args) {
        String s="226";
        int res = numDecodings(s);
        System.out.println(res);
    }
    public static int numDecodings(String s) {
        int len=s.length();

        int[] dp=new int[len+1];
        dp[0]=1;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i-1)!='0'){
                dp[i]+=dp[i-1];
            }

            if (i>=2){
                int k=(s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
                if (k>=10 && k<=26){
                    dp[i]+=dp[i-2];
                }
            }
        }
        return dp[len];
    }
}
