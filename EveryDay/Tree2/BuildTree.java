package LeetCode.Tree2;

import java.util.ArrayList;
import java.util.List;

public class BuildTree {
    public TreeNode isBuild(List<Character> in, List<Character> out){
        //1.如果输入序列为null，则空树
        if (in.isEmpty()){
            return null;
        }
        //2.如果root==null，空树
        //先移除根，构建根节点。
        char rootVal =in.remove(0);
        if (rootVal =='#'){
            //剩余部分
            out.addAll(in);
            return null;
        }
        //3.正常树
        TreeNode root=new TreeNode(rootVal);
        List<Character> residue=new ArrayList<>();
        //递归构建左子树、右子树
        TreeNode left=isBuild(in,residue);
        //构建右子树，左子树构建完了才能构建右子树
        //前序遍历：根左右
        TreeNode right=isBuild(residue,out);

        root.left=left;
        root.right=right;

        return root;
    }

    public void inOrder(TreeNode root){
        if (root==null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
}
