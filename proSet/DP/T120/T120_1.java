package LeetCode.EveryDAY.WEEK.Week5_DP.T120;

import java.util.List;
/**
 * 三角形最小路径和
 * 思路：动规
 * 链接：https://leetcode-cn.com/problems/triangle/
 */
public class T120_1 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        int[][] dp=new int[row+1][row+1];
        dp[0][0]=triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            //j==0时，j-1<0 无意义，都是从正上方来的，所以是dp[i][j]=前i行的第0列的和
            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
            for (int j = 1; j<i; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
            }
            //j==i时，说明是第i行的最右列，上一次也一定是第i-1行的左右列，依此类推
            //j==i时，都是最右列值的和
            dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
        }

        //最小和在dp[n-1][0~n-1]的集合中
        int res=Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            res=Math.min(res,dp[row-1][i]);
        }

        return res;

    }


}
