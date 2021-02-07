package Test.Day35;
/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

import java.util.Scanner;
public class getMax {
    public static int calculateMax(int[] prices) {
        int max=0;
        for (int i = 1; i <prices.length; i++) {
            int m=prices[i]-prices[i-1];
            if(m>0){
                max+=m;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String[] s=sc.nextLine().split(",");
            int[] n=new int[s.length];
            for (int i = 0; i <s.length; i++) {
                n[i]=Integer.parseInt(s[i]);
            }
            int res=calculateMax(n);
            System.out.println(res);
        }
    }
}
