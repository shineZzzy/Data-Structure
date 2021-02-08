package Test.Day35;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 暴力法：直接遍历求取两数之差
 * 结果：正确，但超时
 */
public class BuySell {
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                int temp=prices[j]-prices[i];
                if(temp>max){
                    max=temp;
                }
            }
        }
        return max;
    }
}
