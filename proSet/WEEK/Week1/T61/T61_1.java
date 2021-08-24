package LeetCode.剑指offer.Week1.T61;

import java.util.Arrays;
/**
 * 扑克牌中的顺子
 * 思路：大王小王是万能替补，给数组整体排序后，看最值之差是否在构成顺子的条件范围内
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class T61_1 {
    public static boolean isStraight(int[] nums) {
        int len=nums.length;
        //排序
        Arrays.sort(nums);
        int k=0;
        //统计万能替补的个数
        while (nums[k]==0){
            k++;
        }
        for (int i = k+1; i < len; i++) {
            //有相同的两张牌无法构成顺子
            if (nums[i]==nums[i-1]){
                return false;
            }
        }
        //最大值-最小值<=4可构成顺子
        return nums[len-1]-nums[k]<=4;
    }

    public static void main(String[] args) {
        int[] nums={0,1,2,5,6};
//        int[] nums={9,10,4,0,9};
        boolean res = isStraight(nums);
        System.out.println(res);
    }
}
