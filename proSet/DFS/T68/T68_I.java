package LeetCode1.LIST.Tree.T68;

import LeetCode1.LIST.Tree.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 * TIP：
 * 二叉搜索树
 * 最近公共祖先
     * 节点本身也是自己的最近祖先
     * 最大公共祖先要求离得近、深度尽可能大
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class T68_I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        while (root!=null){
            //p、q都在root的右子树中
            if (root.val<p.val && root.val<q.val){
                root=root.right;
            //p、q都在root的左子树中
            }else if (root.val>p.val && root.val>q.val){
                root=root.left;
            }else {
            //找到了！
                break;
            }
        }
        return root;
    }
}
