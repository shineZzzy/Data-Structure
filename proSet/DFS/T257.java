package LeetCode1.dfs.T257_;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * 题意：给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 思路：从根节点开始遍历，深度优先遍历、
 * 如果遇到叶子节点，直接添加到结果集
 * 如果不是叶子节点，就继续向下递归
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class T257 {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        dfs(root,list,"");
        return list;
    }

    private static void dfs(TreeNode root, List<String> list,String s) {
        if (root==null){
            return;
        }
        StringBuilder sb=new StringBuilder(s);
        sb.append(root.val);
        //叶子节点
        if (root.left==null && root.right==null){
            list.add(sb.toString());
        }else {
            //非叶子节点，继续递归其左右孩子
            sb.append("->");
            dfs(root.left,list,sb.toString());
            dfs(root.right,list,sb.toString());
        }
    }
}
