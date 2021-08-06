package LeetCode.EveryDAY.WEEK.Week3_Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class T297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res=new StringBuilder();
        if (root==null){
            return res.toString();
        }
        TreeNode node=root;
        //前序遍历
        preOrder(root,res);
        return res.toString();
    }

    private void preOrder(TreeNode root, StringBuilder res) {
        //如果为空，用”#“替换，方便之后做反序列化
        //如果直接return，前序遍历无法唯一确定一棵二叉树，但标记了null后，就可以唯一确定了
        if (root==null){
            res.append("#,");
            return;
        }
        res.append(root.val).append(",");
        preOrder(root.left,res);
        preOrder(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int len=data.length();
        if (len==0){
            return null;
        }
        String[] str=data.split(",");
        Queue<String> queue=new LinkedList<>(Arrays.asList(str));
        return dfs(queue);

    }

    private TreeNode dfs(Queue<String> queue) {
        String s=queue.poll();
        //如果此处为"#"，则代表为空
        if (s.equals("#")){
            return null;
        }
        //否则，创建节点，关联左右孩子
        Integer v=Integer.parseInt(s);
        TreeNode root=new TreeNode(v);
        //递归处理左右子树
        root.left=dfs(queue);
        root.right=dfs(queue);
        return root;
    }


    private TreeNode dfs1(String data, int u) {
        if (data.charAt(u)=='#'){
            //跳过当前的"#"和下一个位置的","
            u+=2;
            return null;
        }
        //计算当前节点的值
        int t=0;
        //判断是否为负数
        boolean isMinus =false;
        //如果当前位置是负号
        if (data.charAt(u)=='-'){
            //更新标志位
            isMinus =true;
            //下标后移
            u++;
        }

        //合法位置；不是负号也不是逗号的
        while (data.charAt(u)!=','){
            //计算t的值
            t=t*10+data.charAt(u)-'0';
            u++;
        }
        u++;
        if (isMinus){
            t=-t;
        }
        TreeNode root=new TreeNode(t);
        root.left=dfs1(data,u);
        root.right=dfs1(data,u);

        return root;
    }


}
