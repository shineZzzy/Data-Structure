package Test.Day38;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 和层序遍历相同，仅将ret.add()修改为
 */
public class OrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level= new ArrayList<Integer>();
            int curLever=queue.size();
            for (int i = 0; i <curLever; i++) {
                TreeNode node=queue.poll();
                level.add(node.val);
                //优化---避免超时
                TreeNode left=node.left;
                TreeNode right=node.right;
                if (left!=null){
                    queue.offer(left);
                }
                if (right!=null){
                    queue.offer(right);
                }
            }
            ret.add(0,level);
        }
        return ret;
    }
}
