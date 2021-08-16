package LeetCode.EveryDAY.WEEK.Week5_DP.T300;

/**
 * 最长上升子序列
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class T300 {
    /**
     * 状态：dp[i]：所有以i结尾的上升子序列的长度最大值
     * 状态计算：在以j元素结尾的上升子序列中长度最大的状态 dp[j]+当前第i元素可以构成新的最长子序列
     * 但需满足nums[j]<nums[i] 递增条件：dp[i]=max{dp[j]}+1;
     */
    public static int lengthOfLIS(int[] nums) {
            int len=nums.length;
            int[] dp=new int[len+1];

            for (int i = 0; i < len; i++) {
                //以自己为一个序列，长度为1
                dp[i]=1;
                for (int j = 0; j <i; j++) {
                    //当第j个数做倒数第j个数，且nums[j]<nums[i]升序
                    // 第j个元素结尾构成的子序列的后面+nums[i]
                   //在前j个元素种枚举，看谁+nums[i]更能构成最长串
                    if (nums[j]<nums[i]){
                        //dp[i]随j 的选值在不断更新中...
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
            }
            //res!=dp[len-1]:最后一个状态值只表示以 nums[len - 1] 结尾的「上升子序列」的长度
            //最大值在0~len范围内，res=max{dp[i]}
            int res=Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                res=Math.max(res,dp[i]);
            }
            return res;
    }


    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
}
