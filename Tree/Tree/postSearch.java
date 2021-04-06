package DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

public class postSearch {

    //笨蛋方法
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }else if (root.left!=null && root.right!=null){
            List<Integer> left=postorderTraversal(root.left);
            list.addAll(left);
            List<Integer> right=postorderTraversal(root.right);
            list.addAll(right);
            list.add(root.v);
        }else if (root.left!=null && root.right==null){
            List<Integer> left=postorderTraversal(root.left);
            list.addAll(left);
            list.add(root.v);
        }else if (root.left==null && root.right!=null){
            List<Integer> right=postorderTraversal(root.right);
            list.addAll(right);
            list.add(root.v);
        }else {
            list.add(root.v);
        }
        return list;
    }
    //优化方法
    public static List<Integer> postOrder(TreeNode root){
        if(root==null){
            return null;
        }
        List<Integer> list=new ArrayList<>();
        List<Integer> left=postorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right=postorderTraversal(root.right);
        list.addAll(right);
        list.add(root.v);
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root!=null){
            List<Integer> left=inorderTraversal(root.left);
            list.addAll(left);
            list.add(root.v);
            List<Integer> right=inorderTraversal(root.right);
            list.addAll(right);
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root!=null){
            list.add(root.v);
            List<Integer> left=preorderTraversal(root.left);
            list.addAll(left);
            List<Integer> right=preorderTraversal(root.right);
            list.addAll(right);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root=BuildTree.buildTree2();
        List<Integer>list=postorderTraversal(root);
        System.out.println(list);
    }


}
