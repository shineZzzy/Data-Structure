package LeetCode.剑指offer.Week1.T80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法：暴搜
 */
public class T80 {
    public static int[] numberOfDice(int n) {
        if (n<=0){
            return new int[]{};
        }
        List<Integer> list=new ArrayList<>();
        for (int i = n; i <= n * 6; i++) {
            list.add(dfs(n,i));
        }
        int[] res=new int[list.size()];
        int index=0;
        for (Integer i : list) {
            res[index++]=i;
        }
        return res;
    }

    private static Integer dfs(int n, int sum) {
        if (sum<=0){
            return 0;
        }
        
        if (n==0){
            return sum;
        }
        int res=0;
        for (int i = 1; i <= 6; i++) {
            res+=dfs(n-1,sum-i);
        }
        return res;
    }

    public static void main(String[] args) {
        int n=2;
        int[] res = numberOfDice(n);
        System.out.println(Arrays.toString(res));
    }
}
