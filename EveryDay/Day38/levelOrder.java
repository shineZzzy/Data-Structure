package Test.Day38;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
         val = x;
     }
 }

/**
 * 队列
 * 先判断root是否为null
 * 不为空情况下，将其放入队列中，
 * 层数==队列大小
 * 在当前结点放入队列后，在本层情况下，放入其两个孩子
 * 再回来更新层数，依次遍历每个节点
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/
 */

public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level= new ArrayList<Integer>();
            int curLever=queue.size();
            for (int i = 0; i <curLever; i++) {
                TreeNode node=queue.poll();
                level.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(root.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}
