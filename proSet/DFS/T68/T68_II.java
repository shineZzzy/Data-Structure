package LeetCode1.LIST.Tree.T68;

import LeetCode1.LIST.Tree.TreeNode;

/**
 * 二叉树的最近公共祖先
 *若 root是 p,q的最近公共祖先 ，则只可能为以下情况之一：
 * p和q在 root的子树中，且分列 root的 异侧（即分别在左、右子树中）；
 * p=root,且q在 root的左或右子树中；
 * q = root,且p在 root 的左或右子树中；
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
 */
public class T68_II {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        if (root.val==p.val || root.val==q.val){
            return root;
        }
        //递归左子树
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        //递归右子树
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //p、q节点分别在根节点左右子树中
        if (left!=null && right!=null){
            return root;
        }
        //p、q都在根节点的左子树中
        if (left!=null){
            return left;
        }
        //p、q都在根节点的右子树中
        if (right!=null){
            return right;
        }
        //没找到
        return null;
    }
}
