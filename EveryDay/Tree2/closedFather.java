package LeetCode.Tree2;

public class closedFather {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==p || root==q){
            return root;
        }
        boolean pInLeft=search(root.left,p);
        boolean qInLeft=search(root.left,q);
        if (pInLeft && qInLeft){
            return lowestCommonAncestor(root.left,p,q);
        }
        if (!pInLeft && !qInLeft){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    private boolean search(TreeNode root, TreeNode q) {
        if (root ==null){
            return false;
        }
        if (root ==q){
            return true;
        }
        if (search(root.left,q)){
            return true;
        }
        return search(root.right,q);
    }
}
