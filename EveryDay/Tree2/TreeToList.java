package LeetCode.Tree2;

public class TreeToList {
    private TreeNode last;
    private TreeNode head;
    public TreeNode Convert(TreeNode pRootOfTree) {
        head=last=null;
        inOrder(pRootOfTree);
        return head;
    }
    //创建新节点
    public void add(TreeNode root){
        TreeNode node =new TreeNode(root.val);
        //尾插
        if (last==null){
            head=node;
        }else {
            last.right= node;
        }
        node.left=last;
        last=node;
    }
    public void inOrder(TreeNode root){
        if (root!=null){
            inOrder(root.left);
            //每个节点走到这都得调一次。
            //保证有序。
            add(root);
            inOrder(root.right);
        }
    }
    public void add2(TreeNode node){
        if (last==null){
            head=node;
        }else {
            last.right= node;
        }
        //可以改变node的left，但不能改变right？
        node.left=last;
        last=node;
    }
}
