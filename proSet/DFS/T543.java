package LeetCode1.EveryDAY.Week3.maxPath;

import LeetCode1.EveryDAY.Week3.TreeNode;

/**
 * 二叉树的直径
 * TIP：二叉树的直径=左子树最大深度+右子树最大深度
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class T543 {
    public int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        //求以root为根的左子树、右子树的深度最大值
        dfs(root);
        return res;
    }
    //二叉树的直径=左子树最大深度+右子树最大深度
    private int dfs(TreeNode node) {
        if (node==null){
            return 0;
        }
        int left=dfs(node.left);
        int right=dfs(node.right);
        //记录直径的最大值
        res=Math.max(res,left+right);
        //当前节点node的深度最大值
        return Math.max(left, right)+1;
    }


}
