package LeetCode.剑指offer.Week1.T59;
import java.util.*;

/**
 * 滑动窗口的最大值
 * 思路：暴力法
 * 遍历数组，枚举0~(len-k)位置，窗口值为 k 的所有区间内的最值
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */

public class T59_2 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        if(len==0 || k==0){
            return new int[]{};
        }
        List<Integer> list=new ArrayList<>();
        int max=0;
        //枚举[0,len-k]位置的所有数，找k区间内最值
        for (int i = 0; i <= len-k; i++) {
            max=nums[i];
            //区间：[j,i+k]
            for (int j = i; j < i+k; j++) {
                if (nums[j]>max){
                    max=nums[j];
                }
            }
            list.add(max);
        }
        int[] ret=new int[list.size()];
        int t=0;
        for (Integer n : list) {
            ret[t++]=n;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums={1,-1};
        int k=1;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
