package K.Middle;

import java.util.*;

/**
 * 最接近原点的K个点
 * 输入：坐标数组、K值
 * 输出：离原点最近的K个点
 * 思路：最小的K个数，用map存储距离和坐标，然后将前K个返回
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class T973_1 {
    public static int[][] kClosest0(int[][] points, int k) {
        //HashMap存储方式
        Map<Integer,List<int[]>> map=new TreeMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] temp=points[i];
            int dist= (temp[0]*temp[0])+(temp[1]*temp[1]);
            List<int[]> list=map.getOrDefault(dist,new ArrayList<>());
            list.add(temp);
            map.put(dist,list);
        }

        int[][] res=new int[k][2];
        int i=0;
        for (Integer t:map.keySet()){
            if (i==k){
                break;
            }
            for (int[] m:map.get(t)){
                res[i++]=m;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points1={{1,3},{-2,-2}};
        int[][] points2={{3,3},{5,1},{-2,4}};
        int[][] points3={{1,3},{-2,2},{2,-2}};
        int[][] points4={{6,10},{-3,3},{-2,5},{0,2}};
        int[][] points={{0,1},{1,0}};
        int k=3;
        int[][] res = kClosest(points4, k);
        System.out.println(Arrays.deepToString(res));
    }

    //直接自定义排序
    public static int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0]+o1[1]*o1[1])-(o2[0]*o2[0]+o2[1]*o2[1]);
            }
        });

        int[][] res=new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i]=points[i];
        }
        return res;
    }


}
