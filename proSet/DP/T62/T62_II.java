package LeetCode.EveryDAY.WEEK.Week5_DP.T62;

/**
 * 不同路径 II
 * TIP:机器人只能向下、向右走，求路径中存在障碍物
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class T62_II {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        int[][] dp=new int[m+1][n+1];
//        if (dp[0][0]==1){
//            dp[0][0]=0;
//        }
        //将第0行和第0列的情况抽出来，避免入口有障碍物的情况发生
        for (int i = 0; i < m && obstacleGrid[i][0] ==0; i++) {
            dp[i][0]=1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j]==0; j++) {
            dp[0][j]=1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
//        int[][] nums={{0,0,0},{0,1,0},{0,0,0}};
        int[][] nums={{1,0}};
        int res = uniquePathsWithObstacles(nums);
        System.out.println(res);
    }
}
