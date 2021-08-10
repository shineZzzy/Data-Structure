package SuanFa.Tanxin.T452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球
 * 思路：找重叠部分
 *贪心：
 * 局部最优：当气球出现重叠，一起射，所用弓箭最少。
 * 全局最优：把所有气球射爆所用弓箭最少。
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class T452_1 {
    //贪心：找出最远可以往右移动到的位置(左边的不管在哪都可以，但再右一点点就无法引爆了)
    //每一支箭的射出位置都恰好位于某一个气球的右边界
    public static int findMinArrowShots(int[][] points) {
        int len=points.length;
        if (len==0){
            return len;
        }

        //为了让气球尽可能的重叠，需要对数组进行排序
        //直接return o1[1]-o2[1]，遇到极端样例会溢出
        //[[-2147483646,-2147483645],[2147483646,2147483647]]
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]>o2[1]){
                    return 1;
                }else if (o1[1]<o2[1]){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        int res=1;
        int r=points[0][1];
        //
//        int r=Integer.MIN_VALUE;
//        if (len>=1 && points[0][0]==Integer.MIN_VALUE){
//            res++;
//        }

        //r记录上次设穿气球的最小右边界值
        for (int[] i : points) {
            //只要当前i[0]>r，则发出一支新的箭
            if (i[0]>r){
                r=i[1];
                res++;
            }
            //否则代表本范围内的气球都在上次射出的箭的涉猎范围内
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] point={{2,8},{1,6},{7,12},{10,16}};
        int res = findMinArrowShots(point);
        System.out.println(res);
    }
}
