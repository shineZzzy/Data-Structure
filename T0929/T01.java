package Sloution.T0929;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出数组的所以排列组合序列中第k个值
 */
public class T01 {

    public static void main(String[] args) {
        int n=4;
        int k=9;
        String res = getPermutation(n, k);
        System.out.println(res);
    }
    public static String getPermutation (int n, int k) {
        if (n==0){
            return null;
        }
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=i+1;
        }

        boolean[] used=new boolean[n];
        StringBuilder path=new StringBuilder();
        List<String> res=new ArrayList<>();

        dfs(nums,n,0,used,path,res);

        return res.get(k-1);

    }

    private static void dfs(int[] nums, int n,
                            int start, boolean[] used,
                            StringBuilder path,
                            List<String> res) {

        if (path.length()==n){
            res.add(path.toString());
            return;
        }

        for (int i = 0; i <n; i++) {
            if (used[i]){
                continue;
            }
            path.append(nums[i]);
            used[i]=true;

            dfs(nums,n,start,used,path,res);

            path.deleteCharAt(path.length()-1);
            used[i]=false;
        }
    }
}
