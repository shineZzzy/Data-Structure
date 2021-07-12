package LeetCode1.LIST.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *对称二叉树
 * 思路：
 * 1.对称二叉树的条件
     * 根节点相同，左右子树相对称
 * 2.递归终止的条件
     * 左右节点为空---走到头了也都相同
     * 左右节点不同
     * 左右节点一个为空一个不为空
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 */
public class T28 {
    public static boolean isSymmetric0(TreeNode root) {
        if (root==null){
            return true;
        }
        return dfs(root.left,root.right);
    }

    private static boolean dfs(TreeNode r1, TreeNode r2) {
        if (r1 ==null && r2 ==null){
            return true;
        }
        if (r1 ==null || r2 ==null){
            return false;
        }
        return r1.val== r2.val && dfs(r1.left, r2.right) && dfs(r1.right,r2.left);
    }

    /**
     * 方法二：层序遍历
     * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/solution/gong-shui-san-xie-cong-ju-bu-he-zheng-ti-02qk/
     */
    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.addLast(root);
        //处理空节点
        TreeNode temp=new TreeNode(0x3f3f3f3f);

        while (!deque.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int size=deque.size();
            while (size>0){
                TreeNode node=deque.pollFirst();
                if (!node.equals(temp)) {
                    if (node.left!=null){
                        deque.addLast(node.left);
                    }else {
                        deque.addLast(temp);
                    }
                    if (node.right!=null){
                        deque.addLast(node.right);
                    }else {
                        deque.addLast(temp);
                    }
                }
                //对每一层的节点进行对称判断
                list.add(node.val);
                size--;
            }

            if (!check(list)){
                return false;
            }
        }
        return true;
    }

    //回文
    private static boolean check(List<Integer> list) {
        int i=0,j=list.size()-1;
        while (i<j){
            if (!list.get(i).equals(list.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
