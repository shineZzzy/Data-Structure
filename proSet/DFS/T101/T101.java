package LeetCode1.EveryDAY.Week3.T101;
import LeetCode1.EveryDAY.Week3.TreeNode;

/**
 * 对称二叉树
 * 递归
 * 链接：
 */
public class T101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left==null && right==null){
            return true;
        }
        if (left==null || right==null){
            return false;
        }
        // 当前节点相等
        // 且 当前节点的左孩子和右孩子的值相等
        // 且 当前节点的右孩子和左孩子的值相等
       return left.val==right.val &&
               dfs(left.left,right.right) &&
               dfs(left.right,right.left);
    }


}
