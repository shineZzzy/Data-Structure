package LeetCode.Tree2;



public class TreeBuilt {
    public static TreeNode buildTree2() {
        // 先构造结点
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode e = new TreeNode(15);
        TreeNode f = new TreeNode(7);

        a.left = b;
        a.right = c;

        b.left = null;
        b.right = null;

        c.left = e;
        c.right = f;

        return a;
    }
}
