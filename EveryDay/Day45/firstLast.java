package Test.Day45;
import java.util.Arrays;

/**
 * 在排序数组中找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class firstLast {
    public  static int[] searchRange(int[] nums, int target) {
        if (nums.length==0){
            return new int[]{-1,-1};
        }
        int first=firstIndex(nums,target);
        if (first==-1){
            return new int[]{-1,-1};
        }
        int last=lsatIndex(nums,target);
        return new int[]{first,last};
    }

    private static int firstIndex(int[] nums,int target){
        int left=0;
        int right=nums.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target){
                right=mid-1;
            }else if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        if (left!=nums.length && nums[left]==target){
            return left;
        }
        return -1;
    }
    private static int lsatIndex(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target){
                left=mid+1;
            }else if (nums[mid]< target){
                left =mid+1;
            }else {
                right=mid-1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
//        int[] n={5,7,7,8,8,10};
//        int target=6;
        int[] n={1,4};
        int target=1;
        int[] res=searchRange(n,target);
        System.out.println(Arrays.toString(res));
    }
}
