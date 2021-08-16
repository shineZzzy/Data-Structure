package LeetCode.EveryDAY.WEEK.Week5_DP.T91;

/**
 * 解码游戏
 * 状态dp[i]：所有由前i个数字解密组成的字符串个数的数量(解码方案个数)
 * 状态计算：
 * 最后一个字母由一位数解码得到：dp[i]=dp[i-1]
     * eg:93 --->IC 9解码得到I，只有1种方案，再加上3，得到IC ，结果仍然是1种方案
 * 最后一个字母由两位数字解码得到：dp[i-2]
     * eg:12--->AB/L ,由前两个数字解码得到的所有方案为2：
     * 1 2 :f[2]=f[1]=1
     * 12:f[2]=f[2]+f[0]=1+1=2
 * 当既能单独又能组合时：dp[i]=dp[i-1]+dp[i-2]
 * 但是：考虑上述两种情况是否不存在
 * 当是两位数时，考虑该值是否在[1,26]范围内
 * 当是一位数时，考虑改值是否等于0，0只能构成空串
 * 链接：https://leetcode-cn.com/problems/decode-ways/
 * 青蛙跳台阶的 反三题，可以跳1阶，也可以跳两阶，所有跳法
 * 解码游戏，可以一个一个解，也可以两位两位解，所有解法
 */
public class T91 {
    public static int numDecodings(String s) {
        int len=s.length();
        int[] dp=new int[len+1];
        //初始化，0就构成空串
        //也是为了让后面的字符和下标对应，从1开始
        dp[0]=1;
        for (int i = 1; i <= len; i++) {
            //如果是1位数，当前结果=前i-1个数字解码得到的方案数(由1位数)=1(1个1个解，得到的字符串始终是1个)
            if (s.charAt(i-1)!='0'){
                //dp[i]=dp[i-1] 同等效果，只是因为在初始化时dp[]数组初始值为0，+和=效果就一样了
                dp[i]+=dp[i-1];
            }
            //如果是两位数，当前结果+前i-2个数字解码方案的数(由两位数) (可以两位两位解，那也就能1位1位解，总共=f(1)+f(2))
            if (i>=2){
                //t必须是两位数，避免 01 的情况发生
                int t=(s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
                if (t>=1 && t<=26){
                    dp[i]+=dp[i-2];
                }
            }
        }
        //最终结果是上述两种状态累加的结果，因此dp[len]即为最终方案总数
        return dp[len];
    }

    public static void main(String[] args) {
        String s="12";
        int res = numDecodings(s);
        System.out.println(res);
    }
}
