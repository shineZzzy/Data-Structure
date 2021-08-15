package LeetCode.EveryDAY.WEEK.Week5_DP.T120;

import java.util.List;

/**
 * 三角形最小路径和
 * 思路：动规
 * 链接：https://leetcode-cn.com/problems/triangle/
 */
public class T120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        int[][] dp=new int[row+1][row+1];
        List<Integer> list=triangle.get(0);
        dp[0][0]=list.get(0);
        for (int i = 1; i < row; i++) {
              List<Integer> inner=triangle.get(i);
            for (int j = 0; j <=i; j++) {
                dp[i][j]=Integer.MAX_VALUE;
                //左边来的
                if (j>0){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+inner.get(j));
                }
                //右边来的，不能走到右边界
                if (j<i){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+inner.get(j));
                }
            }
        }

        //res=dp[n-1][0~n-1]  遍历取最小值
        int res=Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            res=Math.min(res,dp[row-1][i]);
        }
        return res;
    }



}
