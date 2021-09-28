package Leet2021_09.T13;

/**
 * 机器人的运动范围
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class T13_1 {
    public static int movingCount(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];

        return dfs(0,0,m,n,0,0,visited,k);
    }
    public static int dfs(int i,int j,int m,
                          int n, int si,int sj,
                          boolean[][] visited,int k){

        if (i>=m|| j>=n || k<(si+sj)||visited[i][j]){
            return 0;
        }
        //标记已经走过的位置
        visited[i][j]=true;

        return 1+dfs(i+1,j,m,n,sum(i+1),sj,visited,k)
                +dfs(i,j+1,m,n,si,sum(j+1),visited,k);
    }

    private static int sum(int i) {
        int sum=0;
        while (i!=0){
            sum+=i%10;
            i/=10;
        }
        return sum;
    }
}
