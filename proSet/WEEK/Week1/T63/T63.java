package LeetCode.剑指offer.Week1.T63;

/**
 * 股票的最大利润
 * 链接:https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class T63 {
    public static int maxProfit(int[] prices) {
        int len=prices.length;
        if (len==0){
            return 0;
        }
        int res=0;
        //min:前i-1个股票价格的最小值
        for (int i = 1,min=prices[0]; i < len; i++) {
            res=Math.max(res,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return res;
    }
}
