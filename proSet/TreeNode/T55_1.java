package LeetCode1.LIST.Tree.T55;

import LeetCode1.LIST.Tree.TreeNode;

/**
 *平衡二叉树
 */
public class T55_1 {
    public static boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        return Math.abs(depth(root.left)-depth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int depth(TreeNode node) {
        if (node==null){
            return 0;
        }

        return Math.max(depth(node.left),depth(node.right));
    }
}
