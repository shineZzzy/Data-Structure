package Leet2021_09.T26;


/**
 * 树的子结构
 * 题意：输入两棵二叉树A和B，判断B是不是A的子结构。
 * 思路：递归
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;


    public TreeNode(int val) {
        this.val = val;
    }
}

public class T26 {
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return dfs(A,B)
                ||isSubStructure(A.left,B)
                ||isSubStructure(A.right,B);
    }

    private static boolean dfs(TreeNode A, TreeNode B) {
        if (B==null){
            return true;
        }

        if (A==null || A.val!=B.val){
            return false;
        }
        return dfs(A.left,B.left)
                && dfs(A.right,B.right);

    }
}
