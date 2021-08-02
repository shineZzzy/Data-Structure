package LeetCode1.EveryDAY.Week3.T101;
import LeetCode1.EveryDAY.Week3.TreeNode;
import java.util.Stack;

/**
 * 对称二叉树
 * 迭代解法
 * 思路：分别从左子树和右子树开始遍历
 * 左：左中右
 * 右：右中左
 * 遍历时并进行节点比较
 */
public class T101_1 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        //同时从最左、最右的两条链进行遍历
        Stack<TreeNode> left=new Stack<>();
        Stack<TreeNode> right=new Stack<>();
        TreeNode cl=root.left;
        TreeNode cr=root.right;
        while (cl!=null|| !left.isEmpty()||cr!=null || !right.isEmpty()){
            while (cl!=null && cr!=null){
                //分别将最左、最右两条链的节点
                left.push(cl);
                right.push(cr);
                cl=cl.left;
                cr=cr.right;
            }
            if (cl!=null || cr!=null){
                return false;
            }
            //处理根节点
            cl=left.peek();
            left.pop();
            cr=right.peek();
            right.pop();
            if (cl.val!=cr.val){
                return false;
            }
            //将左边的当前节点的右子树压入栈中

            cl=cl.right;
            //将右边的当前节点的左子树压入栈中
            cr=cr.left;

        }
        return true;
    }
}
