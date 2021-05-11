package K;

import java.util.Arrays;

/**
 * 按奇偶排序数组II
 * 特点：奇数位对应奇数元素，偶数位对应偶数元素
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 */
public class T922 {
   //双指针定位，偶数放偶数位，奇数放奇数位，i\j指针分别按奇偶位走
    //虽然通过了，但这个方法不好，因为i,j没限制，会下标越界
    public static int[] sortArrayByParityII(int[] nums) {
        if (nums.length==0){
            return null;
        }
        int[] res=new int[nums.length];
        int i=0,j=i+1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k]%2==0){
                res[i]=nums[k];
                i=i+2;
            }else {
                res[j]=nums[k];
                j=j+2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] n1={2,3,4,5,6,7,8};
        int[] n={4,2,5,7};
        int[] res = sortArrayByParityII(n);
        System.out.println(Arrays.toString(res));
    }


    // 偶数在前，奇数在后
    // 思路：先排序，再双指针，遇到奇数往后发，遇到偶数往前放
    public static int[] sortArrayByParityII1(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        Arrays.sort(nums);
        //2345678
        //2468357

        int mid=(nums.length-1)/2+1;
        int i=0,j=mid;
        int[] res=new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
            if (nums[k]%2==0){
                res[i]=nums[k];
                i++;
            }else {
                res[j]=nums[k];
                j++;
            }
        }
        return res;
    }
}
