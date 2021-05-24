package K;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * T1403-非递增顺序的最小子序列
 * 一个数组 nums，请从中抽取一个子序列，满足该子序列的元素之和，
 * 严格大于未包含在该子序列中的各元素之和
 *
 * 链接：https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order/
 *
 * 思路：贪心算法
 * 贪心；每次都取最大的元素
 */
public class T1403 {


    public static List<Integer> minSubsequence2(int[] nums) {
        //对数组整体排序
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        if (nums.length==0){
            return list;
        }
        //每次取最大的元素添加入结果集
        //对在此之前的所有数求和，与结果集中的元素求和，进行比较，找出最短、且最大的子序列
        for (int i=nums.length-1;i>=0;i--){
            list.add(nums[i]);
            int sum=0;
            for (int j = 0; j <i; j++) {
                sum+=nums[j];
            }
            if (getNum2(list)>sum){
                break;
            }
        }
        return list;
    }

    private static int getNum2(List<Integer> list) {
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i);
        }
        return sum;

    }
    public static List<Integer> minSubsequence3(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int sum=0;
        //先对所以的数进行求和
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        Arrays.sort(nums);
        int count=0;
        //每次取最大元素，求和，在与sun-count比较
        for (int i = nums.length-1; i >=0; i--) {
            list.add(nums[i]);
            count+=nums[i];
            if (count>sum-count){
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a={4,4,7,6,7};
        int[] b={4,3,10,9,8};
        int[] c={7,4,2,8,1,7,7,10};
        int[] d={8,8};
        int[] e={1,7,4,7,1,9,4,8,8};
        int[] f={4,10,2,6,1};
        int[] g={3,5};

        List<Integer> res2 = minSubsequence3(e);
        System.out.println(res2);

    }



}
