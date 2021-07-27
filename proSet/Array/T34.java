package LeetCode1.EveryDAY.Array.BinarySearch;
import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * TIP:
 * 排序数组
 * 起始位置、结束位置，按照范围划分 两段性
 * 二分查找
 *
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class T34 {
    public static int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        if (len==0){
            return new int[]{-1,-1};
        }
        int[] res=new int[2];
        //找起始位置
        //范围：target>=x  找出第一次target出现的位置
        int l=0,r=len-1;
        while (l<r){
            //对比下面的区别
            int mid=(l+r)/2;

            if (nums[mid]>=target){
                r=mid;
            }else {
                l=mid+1;
            }
        }

        if (nums[r]!=target){
            return new int[]{-1,-1};
        }
        res[0]=r;
        //找结束位置
        //范围：target<=x 找最后一次target出现的位置
        l=0;
        r=len-1;
        while (l<r){
            //对比上面二分区别
            int mid=(l+r+1)/2;

            if (nums[mid]<=target){
                l=mid;
            }else {
                r=mid-1;
            }
        }
        res[1]=r;
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1};
        int target=1;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
