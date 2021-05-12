package K;

import java.util.Arrays;

/**
 * 三角形最大周长
 * 给定由数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 思路：先排序，排序后最大值在最后，如果可以构成三角形，周长就是最大值，构不成就往前退一位再判断
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle/
 */
public class T976 {
    //V1.0：想多了，考虑到最后三位不一定会构成三角形，那就退一位再判断嘛，不要多此一举加个最值比较
    //通过是没问题，但是不简洁
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int j=nums.length-1;
        int max=0;
        while (j-2>=0){
            int temp=0;
            if (nums[j-2]+nums[j-1]>nums[j]){
                temp=nums[j]+nums[j-1]+nums[j-2];
                max=Math.max(temp,max);
            }
            j--;
        }
        return max;
    }
    //V2.0：优化了(第一次竟然和官解一样，虽然是easy，原来这里是有贪心的思想啊，自己没想那么多，既是数组求周长最大值，那就排个序从后面找)
    public static int largestPerimeter1(int[] nums) {
        if (nums==null || nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int j=nums.length-1;
        while (j-2>=0){
            if (nums[j-2]+nums[j-1]>nums[j]){
                return nums[j]+nums[j-1]+nums[j-2];
            }
            j--;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] n={3,6,2,3,1};
        int res = largestPerimeter1(n);
        System.out.println(res);
    }
}
