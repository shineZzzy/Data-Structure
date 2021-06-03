package LeetCode1.Middle.T1305_;
import java.util.ArrayList;
import java.util.List;

/**
 * 两棵搜索二叉树中的所有元素
 * 题意：给定两棵二叉搜索树，返回一个列表，对两棵树中的值并按升序排序。
 * 思路：中序遍历+归并排序
 * 二叉搜索树特点：中序遍历有序，则对两棵树中序遍历的序列进行归并。
 * 链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;


    public TreeNode(int val) {
        this.val = val;
    }
}
public class T1305 {
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> r1=new ArrayList<>();
        List<Integer> r2=new ArrayList<>();

        //先中序排
        inSort(root1,r1);
        inSort(root2,r2);

        List<Integer>  res=new ArrayList<>();

        //对中序排的两个序列进行归并
        int i=0,j=0;
        while (i<r1.size() || j<r2.size() ){
            if (i < r1.size() && (j==r2.size() || r1.get(i) <= r2.get(j))){
                res.add(r1.get(i++));
            }else {
                res.add(r2.get(j++));
            }
        }
        return res;
    }

    private static void inSort(TreeNode root, List<Integer> list) {

        if (root ==null){
            return;
        }
        inSort(root.left, list);
        list.add(root.val);
        inSort(root.right, list);
    }


    public static void main(String[] args) {

    }

}
