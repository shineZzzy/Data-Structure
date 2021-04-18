package LeetCode.Tree2;

import java.util.ArrayList;
import java.util.List;

/**
 *根据前序遍历、中序遍历的序列构建二叉树
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class searchTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preOrderList=inArrayToList(preorder);
        List<Integer> inOrderList=inArrayToList(inorder);
        return buildTreeInternal(preOrderList,inOrderList);
    }

    private TreeNode buildTreeInternal(List<Integer> preOrderList, List<Integer> inOrderList) {
        if (preOrderList.isEmpty()){
            return null;
        }
        int v=preOrderList.get(0);
        TreeNode root=new TreeNode(v);
        if (preOrderList.size()==1){
            return root;
        }
        //正常树
        int leftSize=inOrderList.indexOf(v);
        //切割
        //左前序+右前序
        List<Integer> leftPre=preOrderList.subList(1,1+leftSize);
        List<Integer> rightPre=preOrderList.subList(1+leftSize,preOrderList.size());
        //左中序+右中序
        List<Integer> leftIn=inOrderList.subList(0,leftSize);
        List<Integer> rightIn=inOrderList.subList(leftSize+1,inOrderList.size());
        //递归-分别构建左右子树
        root.left=buildTreeInternal(leftPre,leftIn);
        root.right=buildTreeInternal(rightPre,rightIn);

        return root;
    }

    private List<Integer> inArrayToList(int[] inorder) {
        List<Integer> list=new ArrayList<>();
        for (int e:inorder){
            list.add(e);
        }
        return list;
    }
}
