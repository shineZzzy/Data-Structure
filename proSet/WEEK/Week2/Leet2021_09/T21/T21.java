package Leet2021_09.T21;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class T21 {
    public static int[] exchange(int[] nums) {
        int len=nums.length;
        if (len==0){
            return nums;
        }
        int i=0,j=len-1;

        while (i<j) {
            while (i<j && (nums[i]&1)==1){
                i++;
            }

            while (i<j && (nums[j]&1)==0){
                j++;
            }
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }

        return nums;
    }

    public static void main(String[] args) {
//        int[] nums={1,2,3,4,5,6};
        int[] nums={1,3,5};
        int[] res = exchange(nums);
        System.out.println(Arrays.toString(res));
    }
}
