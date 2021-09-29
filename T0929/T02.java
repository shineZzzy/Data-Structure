package Sloution.T0929;

/**
 * 数组中乘积值最大的连续子串
 */
public class T02 {

    public static void main(String[] args) {
        int[] nums={2,3,-2,4};
        int res = maxProduct(nums);
        System.out.println(res);
    }
    public static int maxProduct (int[] nums) {
        int len=nums.length;
        if (len==0){
            return 0;
        }

        int[] dp=new int[len+1];
        dp[0]=nums[0];
        int res=dp[0];
        for (int i = 1; i < len; i++) {
            dp[i]=Math.max(dp[i-1]*nums[i],nums[i]);
            res=Math.max(dp[i],res);

        }
        return res;
    }
}
