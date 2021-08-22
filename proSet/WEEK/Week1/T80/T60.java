package LeetCode.剑指offer.Week1.T80;

/**
 * n个骰子的概率之和
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 */
public class T60 {
    /**
     * dp[i][j]:第i个骰子掷出点数j的所有方案的概率之和
     * 当第i个骰子掷出点数k时，dp[i][j]=dp[1][k]*dp[i-1][j-k]
     * 统计每个点数出现的次数，再除以总点数组合数 6^n = 掷出n个骰子，每个点数出现的概率
     */
    public static double[] numberOfDice(int n) {
        if (n<=0){
            return new double[]{};
        }
        int[][] dp=new int[n+1][ n*6+1];

        for (int i = 1; i <= 6; i++) {
            dp[1][i]=1;
        }
        for (int i = 1; i <= n; i++) {  //n个骰子
            for (int j = i; j <= i*6; j++) { //i个骰子，可以掷出的点数 (1个骰子最多掷出的点数是6，2个则为2*6=12)
                for (int k=1;k<=Math.min(j,6);k++){ //k<=j (j 代表sum)
                    dp[i][j]+=dp[i-1][j-k];
                }
            }
        }
        //[n,6n] 因此，共 6n-n+1=5n+1种方案
        double[] res=new double[n*6-n+1];
        int index=0;
        for (int i = n; i <=6*n; i++) {
            //每个点出现的概率=每个点数出现的次数/总点数组合数 6^n
            res[index++]=dp[n][i] / Math.pow(6,n);
        }
        return res;
    }
}
