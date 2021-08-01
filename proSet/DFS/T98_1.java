package LeetCode1.EveryDAY.Week3;
import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class T98_1 {
    //中序遍历+递归
    //特点：搜索二叉树中序遍历有序
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        List<Integer> list=new ArrayList<>();
        return inOrder(root,list);

    }

    private boolean inOrder(TreeNode root,List<Integer> list) {
        if (root==null){
            return true;
        }
        boolean left=inOrder(root.left,list);
        if (list.isEmpty()){
            list.add(root.val);
        }else {
            int v = list.get(list.size() - 1);
            //将当前节点的值，与上一个节点的元素比较
            if (root.val > v) {
                list.add(root.val);
            } else {
                return false;
            }
        }
        boolean right=inOrder(root.right,list);
        //需要左右子树都满足时，才是搜索二叉树
        return left && right;
    }
}
