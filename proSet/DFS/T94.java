package LeetCode1.EveryDAY.Week3.T94_InOrder;

import LeetCode1.EveryDAY.Week3.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 * 迭代：从最左边一条链开始遍历，先将所有左子树节点压入栈中，再弹出栈顶元素，再加入栈顶元素对应的右子树
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class T94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null || !stack.isEmpty()){
            //先将当前节点的最左边一条链全部加入stack中
            //即，先遍历左子树
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            //弹出栈顶元素
            //处理根节点
            cur=stack.peek();
            stack.pop();
            res.add(cur.val);
            //将右子树加入栈中
            //遍历右子树
            cur=cur.right;
        }
        return res;
    }
}
