package LeetCode1.dfs.DFS.T39_;

import java.util.*;

/**
 * 组合总数
 * 描述：给定一个数组，和一个定值，请返回所有数组和=定值的组合，(结果不可重复)
 * 要点：以结果倒推组合
 * 如何对结果去重(区别于47题，不是只要形式一致即为重复)
 * 为何会产生重复？
 * 因为每次通过减法缩小target范围，而展开分支时每一个元素都可重复使用，因此产生重复多个列表
 * eg:[2,2,3] [2,3,2] [3,2,2]
 * 则当以2为搜索起点时，在之后的分支时，不考虑2，从而避免重复结果的产生
 * 链接：https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 */
public class T39 {
    public static List<List<Integer>> combinationSum(int[] candidates,
                                                     int target) {
        List<List<Integer>> res=new ArrayList<>();
        int len=candidates.length;
        if (len==0){
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,len,0,path,target,res);
        return res;
    }

    private static void dfs(int[] candidates, int len,int start,
                            Deque<Integer> path, int target,
                            List<List<Integer>> res) {
        if (target<0){
            return;
        }
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            path.addLast(candidates[i]);
            //因为元素可以重复使用，所有起点还是i，但在此之前的不再使用
            dfs(candidates,len,i,path,target-candidates[i],res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates={2,3,6,7};
        int target=7;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res);
    }
}

//给定值、搜索起点