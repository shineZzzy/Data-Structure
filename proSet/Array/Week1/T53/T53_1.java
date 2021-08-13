package LeetCode.EveryDAY.WEEK.Week5_DP.T53;

/**
 * 最大子序和
 * 思路：动态规划
 * 链接：https://leetcode-cn.com/problems/maximum-subarray/
 */
public class T53_1 {
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return len;
        }


        int res=Integer.MIN_VALUE;
        //记录上一个字串的最大和
        int last=0;
        for (int i = 0; i < len; i++) {
            //计算以nums[i]结尾的字串最大和
            int now=Math.max(last,0)+nums[i];
            //更新最大值
            res=Math.max(res,now);
            //传递当前最大值，开启下一轮
            last=now;
        }

        return res;
    }
}
