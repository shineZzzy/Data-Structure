package Test.Day38;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 拆分数组
 * 思路：先排序再对奇数项整体求和
 * https://leetcode-cn.com/problems/array-partition-i/solution/guan-yu-pai-xu-qu-ou-shu-xiang-de-zheng-que-xing-z/
 *
 */
public class split {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum =0;
        for (int i = 0; i <nums.length; i+=2) {
            maxSum +=nums[i];
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String[] s=sc.nextLine().split(" ");
            int[] n=new int[s.length];
            for (int i = 0; i <s.length; i++) {
                n[i]=Integer.parseInt(s[i]);
            }
            int res=arrayPairSum(n);
            System.out.println(res);
        }
    }
}
