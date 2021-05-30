package K.May;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 卡车上最大单元数
 * 输入：给一个二维数组box(盒子数量，每个箱子的最大容量)，和最大盒子数量
 * 输出：返回卡车可以装载的最大容量
 * 类型：E-背包问题(贪心---最大化问题)
 * 链接：https://leetcode-cn.com/problems/maximum-units-on-a-truck/
 * 思路：先用比较器将数组进行逆序排序，先安排最大容量的箱子
 * 依次先安排最大的，次之，并计算容量
 */
public class T1710 {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        int max=0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize>boxTypes[i][0]){
                max+=boxTypes[i][0]*boxTypes[i][1];
            }else {
                if (truckSize<=0){
                    break;
                }
                max+=truckSize*boxTypes[i][1];
            }
            truckSize-=boxTypes[i][0];
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] box1={{1,3},{2,2},{3,1}};
        int[][] box={{5,10},{2,5},{4,7},{3,9}};
        int size=10;
        int res = maximumUnits(box, size);
        System.out.println(res);
    }
}
