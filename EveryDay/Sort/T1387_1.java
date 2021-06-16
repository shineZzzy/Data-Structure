package Sort;
import java.util.*;

/**
 * 将整数按权重排序
 * 题意：返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
 * 链接：https://leetcode-cn.com/problems/sort-integers-by-the-power-value/
 */
public class T1387_1 {
    public static int getKth(int lo, int hi, int k) {
        if(lo>hi){
            return -1;
        }else if (lo==hi){
            return lo;
        }
        int[][] res=new int[hi-lo+1][2];
        height(lo, hi, res);

        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        return res[k-1][1];
    }

    private static void height(int lo, int hi, int[][] res) {
        int index=0;
        for (int i = lo; i <=hi; i++) {
            if(index>(hi-lo+1)){
                break;
            }
            int count=0;
            int temp=i;
            while (i!=1){
                if(i%2==0){
                    i=i/2;
                }else {
                    i=i*3+1;
                }
                count++;
            }
            res[index][0]=count;
            res[index][1]=temp;
            i=temp;
            index++;
        }
    }

    public static void main(String[] args) {
        int lo=7;
        int hi=11;
        int k=4;
        int res = getKth(lo, hi, k);
        System.out.println(res);
    }
}
