package LeetCode1.EveryDAY.Array.BinarySearch;

/**
 * 寻找峰值
 * TIP：找其中一个区间内极大值
 *      有升有降
 * 链接：https://leetcode-cn.com/problems/find-peak-element/
 */
public class T162 {
    public static int findPeakElement(int[] nums) {
        int len=nums.length;
        if (len==0){
            return 0;
        }
        int l=0,r=len-1;
        //l=r=mid的情况不存在，所以(mid+1)越界情况也不存在
        while (l<r){
            int mid=(l+r)/2;
            //mid和mid的下一个值进行比对
            if (nums[mid]>nums[mid+1]){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums={1,3};
        int peakElement = findPeakElement(nums);
        System.out.println(peakElement);
    }
}
