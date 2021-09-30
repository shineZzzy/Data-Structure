package Leet2021_09.T13;

/**
 * 机器人的运动范围
 * 思路：DFS
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class T13 {
    public static int res=0;
    public static int movingCount(int m, int n, int k) {
        boolean[][] used=new boolean[m][n];
        dfs(used,0,0,k);
        return res;
    }

   public static void dfs(boolean[][] used, int i,
                            int j, int k) {
        //越界判断 || 当前位置的值>k || 已经走过了
        if(i<0||i>=used.length||j<0||j>=used[0].length||used[i][j]||getSum(i,j)>k){
            return;
        }
        //标记当前位置
        used[i][j]=true;
        //更新结果
        res++;
        //搜索上下左右
        dfs(used,i-1,j,k);
        dfs(used,i+1,j,k);
        dfs(used,i,j+1,k);
        dfs(used,i,j-1,k);
    }

    public static int getSum(int i, int j) {
        int res=0;
        if(i==100){
            res=1;
        }else {
            res=i/10+i%10;
        }
        if (i==100){
            res+=1;
        }else {
            res+=j/10+j%10;
        }
        return res;
    }

    public static void main(String[] args) {
        int m=3;
        int n=2;
        int k=17;
        int res = movingCount(m, n, k);
        System.out.println(res);
    }
}
