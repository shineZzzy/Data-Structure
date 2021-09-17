package Sloution.T917;

/**
 * 最大和的连续子数组
 * 算法：动态规划
 * 思路：
 * 状态：dp[i]：表示前i个元素中，可以构成连续子数组的最大和
 * 方程：划分集合发条件，即当前元素选还是不选
 *      选：即加上当前元素可以构成以i结尾的元素中连续子数组的最大和
 *          dp[i]=dp[i-1]+nums[i]
 *     不选：加上当前元素，无法使最大和增大,即维持上一个状态即可
 *          dp[i]=dp[i-1]
 * 结果：遍历dp数组，得到最大和
 * 优化：在计算最大和的过程中，记录当前状态下的最大和，并随状态进行更新
 *
 */
public class T1 {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int res=findMaxSum(nums);
        System.out.println(res);
    }

    public static int findMaxSum(int[] nums){
        int len=nums.length;
        int[] dp=new int[len];

        dp[0] = nums[0];
        int res= nums[0];
        for (int i = 1; i <len; i++){

            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            //随时更新最大和
            if (res< dp[i]){
                res = dp[i];
            }
        }
        return res;
    }


    //方法二
    public static int findMaxSum_1(int[] nums){
        if (nums.length==0){
            return -1;
        }
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            sum= Math.max(sum, 0);
        }
        return max;
    }
}
