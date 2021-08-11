package SuanFa.Tanxin.T134;

/**
 * 加油站
 * TIP:加油站是环形的
 * 链接：https://leetcode-cn.com/problems/gas-station/
 */
public class T134 {
    //方法一：暴力遍历
    //遍历每个加油站，检查以该加油站为起点，是否能走过一圈
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        //遍历每个加油站
        for (int i = 0,j=0; i < n; i++) {
            int count=0;
            //j 记录走过的站点个数,n个是一圈
            for (j = 0; j < n; j++) {
                //确定第几站
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
