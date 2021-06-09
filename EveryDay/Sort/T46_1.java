package LeetCode1.dfs.DFS.T46_;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 题意：给定一个元素不重复的序列，请返回该序列的全排列。
 * 思路：回溯
 * 出口：当查找路径==数组长度时，退出
 * 链接：https://leetcode-cn.com/problems/permutations/
 */
public class T46_1 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if (nums==null || nums.length==0){
            return res;
        }
        int len=nums.length;
        //存储每一条合法路径
        Deque<Integer> path=new LinkedList<>();
        //标记走过的位置
        boolean[] used=new boolean[len];
        dfs(nums,len,0,path,used,res);
        return res;
    }

    private static void dfs(int[] nums,int len, int depth, Deque<Integer> path,
                            boolean[] used, List<List<Integer>> res) {
        if(depth>nums.length){
            return;
        }
        //出口：当合法路径的长度==数组长度，即可退出
        if(depth==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            //走过的就跳过
            if (used[i]){
                continue;
            }
            //进行选择
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,len,depth+1,path,used,res);
            //需要回到上一层节点中，才能重新选择
            //撤销选择
            path.removeLast();
            used[i]=false;
        }
    }
}
