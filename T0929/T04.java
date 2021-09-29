package Sloution.T0929;

import java.util.Arrays;

/**
 * 找出重复字符
 * 题意：数组中至少有一个重复值，将其找出来
 */
public class T04 {
    public static int findDuplicate (int[] nums) {
        int len=nums.length;
        if (len==0){
            return 0;
        }

        Arrays.sort(nums);
        for (int i = 1; i <len ; i++) {
            if (nums[i]==nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
}
