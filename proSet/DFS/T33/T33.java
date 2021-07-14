package LeetCode1.LIST.Tree.T33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 二叉搜索树的后序遍历
 * TIP：二叉搜索树
    * 二叉搜索树特征：
     * 左子树的所有节点值<根节点
     * 右子树的所有节点值>根节点
     * 中序遍历有序
     * 元素无重复
 * 基于特征1、2，作为推断二叉搜索树的正确性依据
 * 最后一个是根节点 之前的序列中必须存在一个拐点 拐点前后的值 要么均大于根 要么均小于根
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class T33 {
    //方法一：递归
    public static boolean verifyPostorder(int[] postorder) {
        int len=postorder.length;
        if (len==0){
            return false;
        }
        return dfs(postorder,0,len-1);
    }

    private static boolean dfs(int[] postorder, int i, int j) {
        //后序遍历：左-右-根
        //postorder[j]==root
        if (i>=j){
            return true;
        }
        //左子树节点<根节点
        int p=i;
        while (postorder[p]<postorder[j]){
            p++;
        }
        //到右子树了
        //右子树节点>根节点
        int m=p;
        while (postorder[p]>postorder[j]){
            p++;
        }
        //当走到最后 p==j了,再缩小检查范围
        return p==j && dfs(postorder,i,m-1) && dfs(postorder,m,j-1);
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] postorder = stringToIntegerArray(line);

            boolean ret =verifyPostorder(postorder);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
