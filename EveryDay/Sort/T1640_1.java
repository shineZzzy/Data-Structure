package K;

import java.util.HashMap;
import java.util.Map;

/**
 * 能否连接形成数组
 * 有两个数组arr，pieces,各数组中元素不重复，请以任意顺序拼接pieces中元素(不允许排序)对元素重新排列看是否可以形成arr
 * 用例说明：
     * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
     * 输出：true
     * 解释：依次连接 [91]、[4,64] 和 [78]
 * 思路：用map保存pieces的各小块的第一个元素，及下标，遍历arr，根据下标对pieces重新连接，看是否可以形成arr

 * 链接：https://leetcode-cn.com/problems/check-array-formation-through-concatenation

 *
 */
public class T1640_1 {
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0],i);
        }
        int[] res=new int[arr.length];
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){
                int[] a=pieces[map.get(arr[i])];
                for (int j = 0; j < a.length; j++) {
                    res[index++]=a[j];
                }
            }
        }

        int i=0,j=0;
        while (i<arr.length || j<res.length){
            if (arr[i]!=res[j]){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr={91,4,64,78};
        int[][] pieces={{78},{4,64},{91}};
        System.out.println(canFormArray(arr, pieces));
    }
}
