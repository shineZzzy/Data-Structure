package LeetCode.剑指offer.Week1.T62;

import java.util.LinkedList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 * 思路：
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class T62 {
    public static int lastRemaining(int n, int m) {
        if (n==0 || m==0){
            return 0;
        }
        List<Integer> list=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index=0;
        while (n>1){
            index=(index+m-1)%n;
            list.remove(index);
            n--;
        }

        return list.get(0);
    }
}
