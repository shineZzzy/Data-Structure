package Test.Day38;

import java.util.ArrayList;
import java.util.List;
/**
 * 递归做法
 * 抽象出一个遍历的方法，给予其层数，当前节点，列表
 * 依次递归处理
 */

public class levelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(1, root, result);
        return result;
    }

    private void dfs(int index, TreeNode root, List<List<Integer>> result) {
        if (result.size() < index) {
            //当前列表长度小于指定层数，添加一个数组用于存放下一层的结点
            result.add(new ArrayList<Integer>());
        }
        //在当前索引位置存入当前结点的值(等效于先在队列中存放根结点，再判断其孩子结点)
        result.get(index - 1).add(root.val);
        if (root.left != null) {
            dfs(index + 1, root.left, result);
        }
        if (root.right != null) {
            dfs(index + 1, root.right, result);
        }
    }
}
