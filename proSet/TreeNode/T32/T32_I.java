package LeetCode1.LIST.Tree.T32;

import LeetCode1.LIST.Tree.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 从上至下打印二叉树
 * TIP：层序遍历
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class T32_I {
    //方法一：层序遍历
    public static int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[]{};
        }
        List<Integer> list=new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode poll=stack.poll();
            if (poll!=null){
                if (poll.left!=null){
                    stack.addLast(poll.left);
                }
                if (poll.right!=null){
                    stack.addLast(poll.right);
                }
                list.add(poll.val);
            }
        }

        int[] res=new int[list.size()];
        int index=0;
        for (Integer i : list) {
            res[index++]=i;
        }
        return res;

    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int[] ret =levelOrder(root);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
