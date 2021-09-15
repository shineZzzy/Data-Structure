package Sloution.金山云;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * 倍数
 * 思路：
     * 现在给你N个正整数，从中选取3个数字的和，刚好能够组成M的倍数。
     * 请问存在多少种不同的选取方案？ 相同的一组数如果次序不同只能算做一种方案，
     * 不同位置的相同数字需当做同一个数字看待。例如一组数字[2,3,3,4]，
     * 从中选取3个数字的和来组成3的倍数，只存在一种方案(2,3,4)。
 * 算法：回溯
 */
public class Solution {
    public static int cnt=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        int res=cntNums(nums,k);
        System.out.println(res);
    }

    private static int cntNums(int[] nums, int k) {
        int len=nums.length;
        if (len==0){
            return 0;
        }

        Arrays.sort(nums);
        Deque<Integer> path=new ArrayDeque<>(3);
        boolean[] used=new boolean[len];
        dfs(nums,len,0,path,used,k);
        return cnt;
    }

    private static void dfs(int[] nums, int len,
                            int start,
                            Deque<Integer> path,
                            boolean[] used,int k) {
        if (path.size()==3){
            int sum=0;
            for (Integer i : path) {
                sum+=i;
            }
            if(sum%k==0){
                cnt++;
            }
            return;
        }

        for(int i=start;i<len;i++){
            if (i-1>0 && (nums[i]==nums[i-1] && !used[i - 1])){
                continue;
            }
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,len,i+1,path,used,k);

            path.removeLast();
            used[i]=false;
        }

    }
}
