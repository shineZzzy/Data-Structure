package K.May;
import java.util.*;

/**
 * 距离顺序排列矩阵单元格
 * 输入：给一个R*C的矩阵，和(r0,c0)的单元格
 * 输出：返回所有单元格的坐标，并按到(ro,c0)距离从小到大顺序排
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 * 思路：
 * 总结：之前一看到这种题就转头走，但还是得面对(略略矫情)
 * 冷静，先画两笔算算距离，找找规律，这是个简单题
 * 相当于：以距离为编号进行排序，和之前那些题一样，就是编号+组合(字符、字符串、数组)
 * 就可以直接将编号作为下标、或者用二维数组、map保存编号、组合，再对编号排序
 *
 */
public class T1640_3 {
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        //用map来保存计算的距离和下标
        Map<Integer, List<int[]>> map=new HashMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //计算每个点到(r0,c0)的距离
                int dist=Math.abs(i-r0)+Math.abs(j-c0);
                //将坐标以list保存
                //如果map中有相同的dist，就将之前的list拿出来，在这个基础上，去添加新的坐标
                //没有相同的dist，就创建一个新的list，去添加坐标
                List<int[]> a=new ArrayList<>();
                if (map.containsKey(dist)){
                    a=map.get(dist);
                }
                a.add(new int[]{i,j});
                map.put(dist,a);

//                List<int[]> list=map.getOrDefault(dist,new ArrayList<>());
//                list.add(new int[]{i, j});
//                map.put(dist,list);
            }
        }

        //遍历map，添加到结果集中
        int[][] res=new int[R*C][2];
        int index=0;
        for (Integer i:map.keySet()){
            for (int[] j:map.get(i)){
                res[index++]=j;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int R=2,C=2,r0=0,c0=1;
        System.out.println(Arrays.deepToString(allCellsDistOrder(R, C, r0, c0)));
    }
}
