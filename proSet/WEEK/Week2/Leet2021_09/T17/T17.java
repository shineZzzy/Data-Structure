package Leet2021_09.T17;

/**
 * 打印从1到最大的n位数
 * 思想：先算出最后一个数，再遍历打印出来
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class T17 {
    public static int[] printNumbers(int n) {
        int end= (int) (Math.pow(10,n)-1);
        int[] res=new int[end];
        for (int i = 0; i < end; i++) {
            res[i]=i+1;
        }
        return res;
    }
}
