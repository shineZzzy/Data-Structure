package LeetCode1.EveryDAY.Array.BinarySearch;

/**
 * 寻找重复数
 * TIP：
     * 无序数组
     * 不允许改变数组
     * 找出重复的那个数！
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
public class T287 {
    public static int findDuplicate(int[] nums) {
        int len=nums.length;
        if (len==0){
            return 0;
        }
        int l=1,r=len-1;
        while (l<r){
            int mid=(l+r)/2;
            int cnt=0;
            for (int i : nums) {
                if (i>=l && i<=mid){
                    cnt++;
                }
            }

            if (cnt>mid-l+1){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums={1,2,4,3,2};
        int res = findDuplicate(nums);
        System.out.println(res);
    }
}
