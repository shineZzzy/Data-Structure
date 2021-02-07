package Test.Day35;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
import java.util.Scanner;
public class getMax3 {

    public static int calculateMax(int[] prices) {
        int b1 = -prices[0], s1 = 0;
        int b2 = -prices[0], s2 = 0;
        for (int i = 1; i < prices.length; ++i) {
            b1 = Math.max(b1, -prices[i]);
            s1 = Math.max(s1, b1 + prices[i]);
            b2 = Math.max(b2, s1 - prices[i]);
            s2 = Math.max(s2, b2 + prices[i]);
        }
        return s2;
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
