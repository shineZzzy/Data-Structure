package Leet2021_09.T13;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * 机器人的运动范围
 * 思路：BFS
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class T13_2 {
    public static int res=0;
    public static int movingCount(int m, int n, int k) {
        boolean[][] used=new boolean[m][n];

        Queue<int[]>queue=new ArrayDeque<>();
        queue.add(new int[]{0,0,0,0});
        while (!queue.isEmpty()){
            int[] inner=queue.poll();
            int x=inner[0];
            int y=inner[1];
            int i=inner[2];
            int j=inner[3];
            if (x>=m || y>=n || k<i+j ||used[x][y]){
                continue;
            }
            used[x][y]=true;
            res++;
            queue.add(new int[]{x+1,y,(x+1)%10!=0?i+1:i-8,j});
            queue.add(new int[]{x,y+1,i,(y+1)%10!=0?j+1:j-8});
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
