package Test.Day39;

/**
 * 求两数之和
 * 方法一：暴力循环
 * 问题：返回二维数组
 * 链接：https://leetcode-cn.com/problems/two-sum/
 */
public class keySum {
    public static int[] twoSum(int[] nums, int target) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j=i+1;j<nums.length;j++){
                sum=nums[j]+nums[i];
                if (sum==target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
