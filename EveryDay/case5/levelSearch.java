package EveryDay.offer.TreeNode.case5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序遍历
 * 注意输出：按层输出
 * 思路：用队列实现，根节点入队，根节点出队，左右孩子入队
 * 链接：https://www.nowcoder.com/practice/04a5560e43e24e9db4595865dc9c63a3?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 */

public class levelSearch {
    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            int size=q.size();
            while (size-->0) {
                TreeNode cur=q.poll();
                if (cur.left!=null ){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
                list.add(cur.val);
            }
            res.add(list);

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root=BuildTree.buildTree2();
        ArrayList<ArrayList<Integer>> res=levelOrder(root);
        System.out.println(res);
    }
}
