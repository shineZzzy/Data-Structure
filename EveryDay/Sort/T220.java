package LeetCode.Top100.sort;

import java.util.TreeSet;

/**
 * 存在重复元素 III
 */
public class T220 {
    //暴力yyds！
    public static boolean containsNearbyAlmostDuplicate0(int[] nums, int k, int t) {
        int n=nums.length;
        if(nums.length ==0 || k == 0|| k == 10000){
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (Math.abs(nums[i]-nums[j])<=t && Math.abs(i-j)<=k ){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = (long) nums[i];
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = ts.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = ts.ceiling(u);
            if(l != null && u - l <= t) return true;
            if(r != null && r - u <= t) return true;
            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            ts.add(u);
            if (i >= k) ts.remove((long) nums[i - k]);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] n={1,5,9,1,5,9};
        int m=2;
        int t=3;
        System.out.println(containsNearbyAlmostDuplicate(n, m, t));
    }

}
