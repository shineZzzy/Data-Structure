package EveryDay.offer.TreeNode.case5;


import java.util.ArrayList;
import java.util.List;

/**
 * 实现二叉树的先序、中序、后序遍历
 * 链接：https://www.nowcoder.com/practice/a9fec6c46a684ad5a3abd4e365a9d362?tpId=190&tqId=35221&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey
 */
public class Search {
    public int[][] threeOrders (TreeNode root) {
        // write code here
        if(root==null){
            return null;
        }
        List<TreeNode> l=new ArrayList<>();
        List<TreeNode> l2=new ArrayList<>();
        List<TreeNode> l3=new ArrayList<>();

        preOrder(root,l);
        inOrder(root,l2);
        postOrder(root,l3);

        int[][] res=new int[3][l.size()];
        for(int i=0;i<l.size();i++){
            res[0][i]=l.get(i).val;
            res[1][i]=l2.get(i).val;
            res[2][i]=l3.get(i).val;
        }
        return res;

    }
    public void preOrder(TreeNode root, List<TreeNode> list){
        if(root==null){
            return;
        }
        list.add(root);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
    public void inOrder(TreeNode root, List<TreeNode> list){
        if(root==null){
            return;
        }
        inOrder(root.left,list);
        list.add(root);
        inOrder(root.right,list);

    }
    public void postOrder(TreeNode root, List<TreeNode> list){
        if(root==null){
            return;
        }
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root);
    }
}
