package LeetCode1.Middle.T452_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 用最小数量的箭引爆气球
 * 题意：找各区间最小交点的个数？
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * 思路：合并区间+排序
 * 总结：虽然结果的时间、空间不是很好，但这是第一个自己写通过的middle题，记录记录
 * 所以还是得多练，见得多了就有思路了，有一就有二，冲冲冲，今天多干两碗饭！
 */
public class T452 {

    public  static int findMinArrowShots(int[][] points) {
        //先对数组整体排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0]==o1[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        //count记录箭的个数
        int count=0,len=points.length;
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int[] inner=points[i];
            int right=inner[0];
            if (list.isEmpty()){
                list.add(inner);
                count++;
            }else {
                //合并小区间(取区间的最小值，以此作为后续的比较依据)
                //如果后面的区间和小区间有交集，就用同一枝箭
                //没有交集，那就再发一支
                int[] last=list.get(list.size()-1);
                if (last[1]>=right && inner[1]>0){
                    last[1]=Math.min(last[1],inner[1]);
                    last[0]=Math.min(last[0],inner[0]);
                }else {
                    list.add(inner);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points1={{10,16},{2,8},{1,6},{7,12}};
        int[][] points2={{7,8},{5,6},{3,4},{1,2}};
        int[][] points3={{2,3},{2,3}};
        int[][] points4={{-2147483646,-2147483645},{2147483646,2147483647}};
        int[][] points5={{1,2},{4,5},{1,5}};
        int[][] points={{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        int res = findMinArrowShots(points);
        System.out.println(res);
    }
}
