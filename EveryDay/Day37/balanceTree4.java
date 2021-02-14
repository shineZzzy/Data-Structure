package Test.Day37;

import java.util.Stack;

/**
 * 迭代---队列
 * 层序遍历
 */
public class balanceTree4 {
    public boolean isSymmetric(TreeNode root) {
        return checkTree(root,root);
    }

    public boolean checkTree(TreeNode p,TreeNode q){
        Stack<TreeNode> Stack=new Stack<TreeNode>();
        Stack.add(p);
        Stack.add(q);
        while(Stack.isEmpty()){
            Stack.peek();
            Stack.peek();
            if(p==null && q==null){
                continue;
            }
            if((p==null || q==null ) ||(p.val!=q.val)){
                return false;
            }
            Stack.add(p.left);
            Stack.add(q.right);

            Stack.add(q.left);
            Stack.add(p.right);
        }
        return true;
    }
}
