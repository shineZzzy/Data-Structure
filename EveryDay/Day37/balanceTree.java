package Test.Day37;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class balanceTree {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }else {
            //递归
            return checkTree(root.left,root.right);
        }
    }

    public boolean checkTree( TreeNode node1, TreeNode node2) {
        if (node1 == node2){
            return true;
        }
        if (node1 ==null|| node2 ==null){
            return false;
        }
        //如果根节点相同，判断两根的左右孩子是否相同
        //镜像！
        return (node1.val== node2.val)
            && checkTree(node1.left, node2.right)
            && checkTree(node1.right,node2.left);
    }
}
