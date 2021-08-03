package LeetCode1.EveryDAY.Week3.maxPath;

import LeetCode1.EveryDAY.Week3.TreeNode;

public class T124 {
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return res;

    }

    private int dfs(TreeNode root) {
        if (root==null){
            return 0;
        }
        //做一点优化
//        int left=dfs(root.left);
//        int right=dfs(root.right);

        //如果经过当前节点的最大权重<0，没有参考意义，剪枝
        //只有经过该节点的最大权重>0时，才会选用当前节点
        int left=Math.max(dfs(root.left),0);
        int right=Math.max(dfs(root.right),0);
        //更新最大值
        //经过当前节点的最大权重和=左子树的最大权重和+右子树的最大权重和+当前节点的值
        res=Math.max(res,left+right+root.val);
        return root.val+Math.max(left,right);
    }
}
