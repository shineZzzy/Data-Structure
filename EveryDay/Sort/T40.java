package LeetCode1.dfs.DFS.T39_;

import java.util.*;

/**
 * 组合总和
 * 描述：数组、定值、数组元素只能使用一次(不重复)，输出所有等于定值的组合
 *  T39 VS T40:
 *  T39:数组元素允许被无限次使用
 *  T40:数组元素只能使用一次
 */
public class T40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len=candidates.length;
        List<List<Integer>> res=new ArrayList<>();
        if (len==0){
            return res;
        }
        Arrays.sort(candidates);
        boolean[] used=new boolean[len];
        Deque<Integer> path=new ArrayDeque<>();
        dfs(candidates,len,0,path,res,used,target);
        return res;
    }

    private static void dfs(int[] candidates, int len,
                            int start, Deque<Integer> path,
                            List<List<Integer>> res,boolean[] used,int target) {

        if (target<0){
            return;
        }
        if (target==0){
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < len; i++) {
            if (used[i] || (i>0 && candidates[i]==candidates[i-1] && !used[i-1])){
                continue;
            }
            path.addLast(candidates[i]);
            used[i]=true;
            dfs(candidates,len,i,path,res,used,target-candidates[i]);
            path.removeLast();
            used[i]=false;
        }
    }

    public static void main(String[] args) {
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> res = combinationSum2(candidates, target);
        System.out.println(res);

    }
}
