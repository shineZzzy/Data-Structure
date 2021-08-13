package LeetCode.EveryDAY.WEEK.Week5_DP.T53;
/**
 * 最大子序和
 * 思路：动态规划
 * 链接：https://leetcode-cn.com/problems/maximum-subarray/
 */
public class T53 {
    public static int maxSubArray(int[] nums) {
        int len=nums.length;
        if (len==0){
            return len;
        }
        int[] dp=new int[len];
        dp[0]=nums[0];
        //枚举每一个元素，计算以该元素为结尾的子串的和最大值
        for (int i = 1; i < len; i++) {
            if (dp[i-1]<0){
                dp[i]=nums[i];
            }else {
                dp[i]=nums[i]+dp[i-1];
            }
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        System.out.println(res);
    }
}
