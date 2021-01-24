package Test.T0122;
public class balance {
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int high = leftHeight - rightHeight;
        if (!(high == -1 || high == 0 || high == 1)) {
            return false;
        }
        return  isBalanced(root.left) && isBalanced(root.right);
    }
}
