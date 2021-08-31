package LeetCode.剑指offer.Week1.T84;

/**
 * 树中两个结点的最低公共祖先
 * 链接：https://www.acwing.com/problem/content/84/
 */
public class T84 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }

        if (root==p || root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if (left!=null && right!=null){
            return root;
        }

        if (left!=null){
            return left;
        }
        return right;
    }
}
