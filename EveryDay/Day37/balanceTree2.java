package Test.Day37;

/**
 * 方法二：递归
 * 镜像树：
 * 它们的两个根结点具有相同的值
 * 每个树的右子树都与另一个树的左子树镜像对称
 * 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution
 */
public class balanceTree2 {
    public boolean isSymmetric(TreeNode root) {
        return checkTree(root,root);
    }
    public boolean checkTree( TreeNode node1, TreeNode node2) {
        if (node1 ==null && node2==null){
            return true;
        }
        if (node1 ==null || node2 ==null){
            return false;
        }
        //如果根节点相同，判断两根的左右孩子是否相同
        //镜像！
        return (node1.val== node2.val)
            && checkTree(node1.left, node2.right)
            && checkTree(node1.right,node2.left);
    }
}
