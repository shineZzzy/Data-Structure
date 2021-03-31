package EveryDay.offer.TreeNode.case3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化
 * 考察重点：层序遍历和前序遍历
 * 链接： https://www.nowcoder.com/practice/d6425eab86fc402085f9fafc0db97cc2?tpId=101&tqId=33231&rp=1&ru=%2Fta%2Fprogrammer-code-interview-guide&qru=%2Fta%2Fprogrammer-code-interview-guide%2Fquestion-ranking&tab=answerKey
 */

public class solution {

    public static StringBuilder levelSerial(TreeNode root,StringBuilder sb){
        Queue<TreeNode> queue=new LinkedList<>();
        sb.append(root.val+"!");
        queue.add(root);
        while (!queue.isEmpty()){
            root=queue.poll();
            if (root.left!=null){
                sb.append(root.left.val+"!");
                queue.add(root.left);
            }else {
                sb.append("#!");
            }
            if (root.right!=null){
                sb.append(root.right.val+"!");
                queue.add(root.right);
            }else {
                sb.append("#!");
            }
        }
        return sb;
    }
    public static StringBuilder preSerial(TreeNode root,StringBuilder sb){
        if (root==null){
            return sb.append("#!");
        }
        sb.append(root.val+"!");
        preSerial(root.left,sb);
        preSerial(root.right,sb);
        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        TreeNode root = createTree(br);

        StringBuilder sb = new StringBuilder();
        preSerial(root,sb);
        System.out.println(sb);
        //将sb清空，再去层序遍历
        sb.delete(0, sb.length());
        levelSerial(root,sb);
        System.out.println(sb);
        br.close();
    }

    private static TreeNode createTree(BufferedReader br) throws IOException {
        String[] rawInput = br.readLine().trim().split(" ");
        int rootVal = Integer.parseInt(rawInput[0]);
        int leftVal = Integer.parseInt(rawInput[1]);
        int rightVal = Integer.parseInt(rawInput[2]);
        TreeNode root = new TreeNode(rootVal);
        if (0 != leftVal) {
            root.left = createTree(br);
        }

        if (0 != rightVal) {
            root.right = createTree(br);
        }
        return root;

    }

}
