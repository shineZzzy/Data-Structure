package LeetCode.EveryDAY.WEEK.Week5_DP.T198;

/**
 * 打家劫舍
 * 思路：在一堆值中选择几个不连续的数，得出选择数的最大值
 * 链接：https://leetcode-cn.com/problems/house-robber/
 */
public class T198 {
    public static int rob(int[] nums) {
        int len=nums.length;
        int[] f=new int[len+1];
        int[] g=new int[len+1];

        for (int i = 1; i <= len; i++) {
            //如果不选第i个元素，就在上一个状态：不选第i-1个元素的最大值和选第i-1个元素的最大值中取max
            f[i]=Math.max(f[i-1],g[i-1]);
            //nums[i-1]并不是表示加上第i-1个元素的值
            //是nums遍历从下标为1开始的，第i个元素的下标则是i-1

            //如果选第i个元素，则第i-1个元素一定不能选，
            //因此是不选第i-1个元素所得最大值加上当前元素的值，
            //得到本状态下，选择第i个元素所有方案中的最大值。
            g[i]=f[i-1]+nums[i-1];
        }
        //下标从1开始，范围为0~len，故f[n]
        //若n-1：遇到[]  n-1=-1下标越界了
        return Math.max(f[len],g[len]);
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        int res = rob(nums);
        System.out.println(res);
    }
}
