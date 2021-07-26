package LeetCode1.EveryDAY.Array.BinarySearch;

import java.util.Arrays;

public class T34 {
    public static int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        if (len==0){
            return null;
        }
        int[] res=new int[2];
        int l=-1,r=len-1;
        while (l<r){
            int mid=(l+r)/2;
            if (nums[mid]>target){
                r=mid;
            }else {
                if (nums[mid]==target){
                    res[0]=l;
                }
                l=mid+1;
            }
        }
        res[1]=r;
        return res;
    }

    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target=8;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
