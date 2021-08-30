package LeetCode.剑指offer.Week1.T66;

import java.util.Arrays;
/**
 * 构建乘积数组
 * 思路：暴力搜索,越过自己
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */
public class T66 {
    //思路正确，特殊用例超时了
    public static int[] constructArr(int[] a) {
        int len=a.length;
        int[] res=new int[len];
        for (int i = 0; i < len; i++) {
            int temp=1;
            for (int j = 0; j < len; j++) {
                if (i!=j){
                    temp*=a[j];
                }
            }
            res[i]=temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int[] res = constructArr(nums);
        System.out.println(Arrays.toString(res));
    }
}
