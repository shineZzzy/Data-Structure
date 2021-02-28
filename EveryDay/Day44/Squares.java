package Test.Day44;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按非递减顺序排序。
 */
public class Squares {
    public int[] sortedSquares(int[] nums) {
        int[] n=new int[nums.length];
        for (int i = 0; i <n.length ; i++) {
            n[i]=nums[i]*nums[i];
        }
        Arrays.sort(n);
        return n;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int[] n={};
        }
    }
}
