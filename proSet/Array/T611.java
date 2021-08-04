package LeetCode1.EveryDAY.Array.BinarySearch.T611;
import java.util.Arrays;

/**
 * 有效三角形的个数
 * 思路：固定最大值，再从一个有序数组中找两个数的和大于nums[i],利用首尾指针和单调性求解
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number/
 */
public class T611 {
    public static int triangleNumber(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        int cnt=0;
        for (int i =len-1; i >=2; i--) {
            int j=0;
            int k=i-1;
            while (j<k){
                if (nums[j]+nums[k]>nums[i]){
                    cnt+=k-j;
                    k--;
                }else {
                    j++;
                }
            }
        }
        return  cnt;
    }

    public static void main(String[] args) {
        int[] nums={2,4,3,4};
        int res = triangleNumber(nums);
        System.out.println(res);
    }
}
