package offer.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的元素
 * 题意：在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 注意：如果某些元素不在0～n-1 的范围内，返回-1
 */
public class T03 {
    //空间复杂度o(1) 时间复杂度o(n)
    public static int findRepeatNumber0(int[] nums) {
        int len=nums.length;
        //遍历数组找出超出范围的，直接返回-1
        for (int i : nums) {
            if(i< 0||i>=len){
                return -1;
            }
        }
        //一个萝卜一个坑，将每个元素放在对应的下标上，主要是：交换
        //如果对应坐标上元素与之不同，则交换，直到不能换位置，就返回-1;
        //如果对应坐标上有元素与之相等，则说明重复了，直接返回
        for (int i = 0; i < len; i++) {
            while (i!=nums[i] && nums[nums[i]]!=nums[i]){
                swap(i,nums[i],nums);
                i++;
            }
            if (i!=nums[i]  && nums[i]==nums[nums[i]]){
                return nums[i];
            }
        }
        return -1;
    }

    private static void swap(int i, int j,int[] arr) {
        int temp= arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }

    public static void main(String[] args) {
        int[] num={2,3,5,4,3,2,6,7};
        int res = findRepeatNumber(num);
        System.out.println(res);
    }

    //哈希，用map保存元素和其下标，一边保存，一边遍历数组，有遇到一样的就返回
    //时间、空间都不高
    public static int findRepeatNumber(int[] nums) {
        int len=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])){
                return nums[i];
            }
            map.put(nums[i],i);
        }
        return -1;
    }
}
