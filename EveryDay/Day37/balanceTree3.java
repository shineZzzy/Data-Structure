package Test.Day37;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 迭代---队列
 * 层序遍历
 */
public class balanceTree3 {
    public boolean isSymmetric(TreeNode root) {
        return checkTree(root,root);
    }

    public boolean checkTree( TreeNode node1, TreeNode node2) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        //结点入队
        q.offer(node1);
        q.offer(node2);
        //如果队列不为空，且连续两个结点值相等，则为镜像
        while (!q.isEmpty()) {
                //取出两个结点进行比较
                node1 = q.poll();
                node2 = q.poll();
                if (node1 == null && node2 == null) {
                    continue;
                }
                if ((node1 == null || node2 == null) || (node1.val != node2.val)) {
                    return false;
                }
                //将两个结点的左右子结点按相反的顺序插入队列中
                q.offer(node1.left);
                q.offer(node2.right);

                q.offer(node1.right);
                q.offer(node2.left);
        }
        return true;

    }
}
