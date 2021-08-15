package LeetCode.EveryDAY.WEEK.Week5_DP.T62;

/**
 * 不同路径
 * TIP：机器人只能向右、向下走
 * 每个位置的路径 = 该位置左边的路径 + 该位置上边的路径
 * 链接：https://leetcode-cn.com/problems/unique-paths/
 */
public class T62 {
    public static int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
//        dp[0][0]=0;
        //dp[i][j]：表示经过第i行j列的位置所有的路径和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //i==0，上一个点肯定不能是从上边来的，只能是左边来的，所以是按行走的，只有当前行对应的1条路径
                //j==0，上一个点肯定不能是从左边来的，只能是从上边来的，所以是按列走的，只有当前列对应的1条路径
                if (i==0||j==0){
                    dp[i][j]=1;
                }else {
                    //第i行j列的位置的路径=上边的+左边的
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        //
        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        int m=3;
        int n=7;
        int res = uniquePaths(m, n);
        System.out.println(res);
    }
}
