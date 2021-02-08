package Test.Day35;

/**
 * 优化遍历：先找到本阶段[历史股票最低点]，再考虑每一天在历史最低点情况下卖出，得出最大利润值
 * 即边更新最低点，边找最大值
 */
public class BuySell2 {
    public int maxProfit(int[] prices) {
        int max=0;
        int min=prices[0];
        for (int i = 0; i <prices.length; i++) {
            if (prices[i]<min){
                min=prices[i];
            }else if (prices[i]-min>max){
                max=prices[i]-min;
            }
        }
        return max;
    }
}
