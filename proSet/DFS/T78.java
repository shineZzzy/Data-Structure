package LeetCode1.dfs.DFS.T78_;

import java.util.*;

/**
 * 子集
 * 题意：给定一个数组，返回该数组的所有子集
 * 注意：结果集不可重复
 * 链接：https://leetcode-cn.com/problems/subsets/
 */
public class T78 {
    public static List<List<Integer>> subsets(int[] nums) {
        int len=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        if (len == 0){
            return res;
        }
        Arrays.sort(nums);
        Deque<Integer> path=new ArrayDeque<>();
        dfs(nums,len,0,path,res);
        return res;
    }

    private static void dfs(int[] nums, int len,
                            int start,Deque<Integer> path,
                            List<List<Integer>> res) {

        res.add(new ArrayList<>(path));
        for (int i = start; i < len; i++) {
            path.addLast(nums[i]);
            System.out.println("递归之前-->"+path);
            dfs(nums,len,i+1,path,res);
            path.removeLast();
            System.out.println("递归之后-->"+path);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }
}
