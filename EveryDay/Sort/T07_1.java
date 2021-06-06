package offer.week1;

import java.util.ArrayList;
import java.util.List;

public class T07_1 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preOrder=ArrayToList(preorder);
        List<Integer> inOrder=ArrayToList(inorder);

        return buildTreeInternal(preOrder,inOrder);
    }

    private static TreeNode buildTreeInternal(List<Integer> preOrder, List<Integer> inOrder) {
        if (preOrder.isEmpty()){
            return null;
        }
        int v=preOrder.get(0);
        TreeNode root=new TreeNode(v);
        if (preOrder.size()==1){
            return root;
        }
        int leftSize=inOrder.indexOf(v);

        List<Integer> leftPre=preOrder.subList(1,1+leftSize);
        List<Integer> rightPre=preOrder.subList(leftSize+1,preOrder.size());


        List<Integer> leftIn=inOrder.subList(0,leftSize);
        List<Integer> rightIn=inOrder.subList(1+leftSize,inOrder.size());


        root.left=buildTreeInternal(leftPre,leftIn);
        root.right=buildTreeInternal(rightPre,rightIn);
        return root;
    }

    private static List<Integer> ArrayToList(int[] inorder) {
        List<Integer> list=new ArrayList<>();
        for (int i : inorder) {
            list.add(i);
        }
        return list;
    }
}
