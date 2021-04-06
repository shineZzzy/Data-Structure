package DataStructure.Tree;

public class NodeSearch {
    public static void preOrder(TreeNode root){
        if (root!=null){
            System.out.print(root.v+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
