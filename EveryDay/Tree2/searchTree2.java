package LeetCode.Tree2;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据中序遍历、后序遍历序列构建二叉树
 *链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class searchTree2 {
    private List<Integer> inArrayToList(int[] inorder) {
        List<Integer> list=new ArrayList<>();
        for (int e:inorder){
            list.add(e);
        }
        return list;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inorderList=inArrayToList(inorder);
        List<Integer> postorderList=inArrayToList(postorder);
        return buildTreeInternal(inorderList,postorderList);
    }

    private TreeNode buildTreeInternal(List<Integer> inorderList,List<Integer> postorderList){
        if(inorderList.isEmpty()){
            return null;
        }
        int v=postorderList.get(postorderList.size()-1);
        TreeNode root=new TreeNode(v);
        if(postorderList.size()==1){
            return root;
        }

        //根据根在后序遍历序列中的下标，确定左右子树的序列
        int leftSize=inorderList.indexOf(v);
        //中序遍历中左右子树的序列
        List<Integer> leftIn=inorderList.subList(0,leftSize);
        List<Integer> rightIn=inorderList.subList(leftSize+1,inorderList.size());
        //后序遍历中左右子树的序列
        List<Integer> leftPost=postorderList.subList(0,leftSize);
        List<Integer> rightPost=postorderList.subList(leftSize,postorderList.size()-1);

        //递归构建左右子树
        root.left=buildTreeInternal(leftIn,leftPost);
        root.right=buildTreeInternal(rightIn,rightPost);
        return root;
    }
}
