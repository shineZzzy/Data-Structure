package LeetCode1.Sort;
import java.util.Arrays;

/**
 * 数组中最大数对和的最小值
 * TIP：读懂题意，就是简单题
 * 链接：https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/
 */

public class T1877 {
    public static int minPairSum0(int[] nums) {
        int len=nums.length;
        if (len==0){
            return 0;
        }
        Arrays.sort(nums);
        int i=0,j=len-1;
        int max=0;
        while (i<=j){
            max=Math.max(max,nums[i]+nums[j]);
            i++;
            j--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={2,3,3,5};
        int res=minPairSum(nums);
    }

    private static int minPairSum(int[] nums) {
        int n=nums.length-1;
        int res=0;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; ++i) {
            res = Math.max(res, nums[i] + nums[n - 1 - i]);
        }
        return res;
    }
}
