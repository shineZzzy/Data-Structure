package LeetCode.Tree2;

import java.util.Deque;
import java.util.LinkedList;

public class depthSearch {

    public static void preOrder(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode cur=root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                System.out.print(cur.val+" ");
                cur=cur.left;
            }
            TreeNode top=stack.pop();
            cur=top.right;
        }
    }
    public static void inOrder(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode cur=root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode top=stack.pop();
            System.out.print(top.val+" ");
            cur=top.right;
        }
    }
    public static void postOrder(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode cur=root;
        TreeNode last=null;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode top=stack.peek();
            if (top.right==null){
                //左子树
                stack.pop();
                last=top;
                System.out.print(top.val+" ");
            }else if (top.right==last){
                //从右子树回
                stack.pop();
                last=top;
                System.out.print(top.val+" ");
            }else {
                //左子树
//                System.out.print(top.val+" ");
                cur=top.right;
            }

        }
    }

    public static void main(String[] args) {
        TreeNode root=TreeBuilt.buildTree2();
//        inOrder(root);
//        preOrder(root);
        postOrder(root);

    }

}
