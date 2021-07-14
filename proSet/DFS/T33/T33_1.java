package LeetCode1.LIST.Tree.T33;

import java.util.Stack;

/**
 * 方法二：单调栈
 * 二叉树的后序遍历：左-右-根
 * 二叉树的前序遍历：根-左-右
 * 二叉搜索树的特点：右>根>左
 * 通过倒序后序遍历序列，来判断是否为二叉搜索树
 * 为什么不能正序判断？得先找到根，才能确定左右子树
 */
public class T33_1 {
    public static boolean verifyPostorder(int[] postorder) {
        //递增栈
        Stack<Integer> stack=new Stack();
        int root=Integer.MAX_VALUE;
        int len=postorder.length-1;
        for (int i =len; i >=0; i--) {
            //左子树节点<根节点
            if (postorder[i]>root){
                return false;
            }
            //只要栈不空，且栈顶元素>当前元素，就更新根节点、出栈
            /**
             * 栈顶元素>当前元素：表示向根节点的左子树走
             * 出栈：让右子树的节点都出栈，不再记录，已经走过了就不会再回到右子树了
             */
            while (!stack.isEmpty() && (stack.peek()>postorder[i])){
                root=stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
