package Sloution.T0923;


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class T005 {
    public static int sum;
    public int maxPathSum (TreeNode root) {
        if (root==null){
            return 0;
        }
        sum=0;
        dfs(0,root);
        return sum;
    }

    private void dfs(int k, TreeNode root) {
        if (root==null){
            return;
        }
        int val= k +root.val;
        if (root.left==null && root.right==null){
            sum+=val;
        }
        sum=Math.max(val,sum);
        dfs(val,root.left);
        dfs(val,root.right);
    }
}
