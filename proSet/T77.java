package LeetCode1.dfs.DFS.T77_;

import java.util.*;

/**
 * 组合
 * 题意：给定一个n和k，求1~n中所有可能的k个数的组合
 * 思路：将n转为数组，利用组合总数一题的思路，从[1....n]的数组中任选一个数，进行排列组合
 * 出口：当path的size==k时，一个排列完成
 * 链接：https://leetcode-cn.com/problems/combinations/
 */
public class T77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        if (n==0 || k==0 || n<k){
            return res;
        }
        int[] nums=new int[n];
        for (int i = 0; i <n; i++) {
            nums[i]=i+1;
        }
//        System.out.println(Arrays.toString(nums));
        boolean[] used=new boolean[n];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums,0,k,used,path,res);
        return res;
    }

    private static void dfs(int[] nums, int start,
                            int k, boolean[] used,
                            Deque<Integer> path,
                            List<List<Integer>> res) {

        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <nums.length; i++) {
            if (used[i]){
                continue;
            }

            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,i,k,used,path,res);
            path.removeLast();
            used[i]=false;
        }

    }

    public static void main(String[] args) {
        int n=4;
        int k=2;
        List<List<Integer>> res = combine(n, k);
        System.out.println(res);
    }
}
