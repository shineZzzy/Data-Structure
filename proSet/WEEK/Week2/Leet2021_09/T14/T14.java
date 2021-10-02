package Leet2021_09.T14;

/**
 * 剪绳子
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
public class T14 {
    public static int cuttingRope(int n) {
        if (n<2){
            return 0;
        }
        if (n==2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        //dp[i]表示长度为i的绳子至少分成两段的最大乘积
        int[] dp = new int[n + 1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;

        for (int i = 4; i <= n; i++) {
            int max=0;
            for (int j=1;j<=i;j++){
                int temp=dp[j]*dp[i-j];
                if (max<temp){
                    max=temp;
                    dp[i]=max;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=8;
        int res = cuttingRope(n);
        System.out.println(res);
    }
}
