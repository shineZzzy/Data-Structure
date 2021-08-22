package LeetCode.剑指offer.Week1.T80;

import java.util.Arrays;

/**
 * 骰子的点数
 * 思路：
 * 链接：https://www.acwing.com/problem/content/description/76/
 */
public class T80_1 {
    public static int[] numberOfDice(int n) {
        if (n<=0){
            return new int[]{};
        }
        int[][] dp=new int[n+1][ n*6+1];
        dp[0][0]=1;
        for (int i = 1; i <= n; i++) {  //n个骰子
            for (int j = i; j <= n*6; j++) { //i个骰子，可以掷出的点数 (1个骰子最多掷出的点数是6，2个则为2*6=12)

                for (int k=1;k<=6;k++){ //k<=j (j 代表sum)
                    if (k<=j) {
                        dp[i][j]+=dp[i-1][j-k];
                    }
                }
            }
        }
        //[n,6n] 因此，共 6n-n+1=5n+1种方案
        int[] res=new int[n*6-n+1];
        int index=0;
        for (int i = n; i <= n*6; i++) {
            //统计n个色子掷出每个点数的次数
            res[index++]=dp[n][i];
        }
        return res;
    }
    public static void main(String[] args) {
        int n=2;
        int[] res = numberOfDice(n);
        System.out.println(Arrays.toString(res));
    }
}
