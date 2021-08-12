package SuanFa.Tanxin.T134;
/**
 * 加油站
 * 链接：https://leetcode-cn.com/problems/gas-station/
 */

public class T134_1 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        //优化：当以i为出发点时，在j站点处失败了，
        //那么途径的任一个站点为起点到该点同样会失败，
        //因此直接跳过这些失败的站点，从i+j+1处重新开始

        //以i站点为起点
        for (int i = 0,j=0; i < n; i+=j+1) {
            int count=0;
            //j 记录走过的站点个数,n个是一圈
            for (j = 0; j < n; j++) {
                //确定第几站，加油站是环形的
                //出发点+走过的站点个数 除以总数，余数就是当前站点位置
                int k=(i+j)%n;
                //剩余油量
                count+=gas[k]-cost[k];
                if (count<0){
                    break;
                }
            }
            //如果已经走了一圈了说明i点符合条件
            if (j>=n){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas={1,2,3,4,5};
        int[] cost={3,4,5,1,2};
        int res = canCompleteCircuit(gas, cost);
        System.out.println(res);


    }
}
