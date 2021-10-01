package Leet2021_09.T14;

/**
 * 剪绳子
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
public class T14_I {
    public int cuttingRope(int n) {
        //dp[i]表示长度为i的绳子至少分成两段的最大乘积
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {

            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        return dp[n];
    }
}
