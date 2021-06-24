package LeetCode1.LIST.T15_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 思路：排序+双指针
 * 链接：https://leetcode-cn.com/problems/3sum/
 */
public class T15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int len=nums.length;
        if (len==0){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len-2; i++) {
            if (nums[i]>0){
                break;
            }
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int target=-nums[i];
            int left=i+1;
            int right=len-1;
            while (left<right){
                if (nums[left]+nums[right]==target){
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }else  if (nums[left]+nums[right]<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={-4,1,-1,0,-1,2};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }
}
