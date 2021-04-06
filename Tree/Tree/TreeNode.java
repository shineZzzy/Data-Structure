package DataStructure.Tree;

public class TreeNode {
    int v;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return String.format("TreeNode{%c}",v);
    }
}
