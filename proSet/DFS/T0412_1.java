package LeetCode1.dfs.DFS.T0412_;


/**
 * 求和路径
 * 思路：递归、dfs
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci/
 */
public class T0412_1 {
    public static int pathSum(TreeNode root, int sum) {
        if (root==null){
            return 0;
        }
        return dfs(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    private static int dfs(TreeNode root, int sum) {
        if (root==null){
            return 0;
        }
        sum-=root.val;
        int count =0;
        if (sum==0){
            count =1;
        }
        return count +dfs(root.left,sum)+dfs(root.right,sum);
    }


}
