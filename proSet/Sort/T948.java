package Sort.T948_;

import java.util.Arrays;

/**
 * 令牌放置
 * 思路：排序+贪心+双指针
 * 先对数组整体排序，贪心思想，前面的牌翻正面，后面的牌翻反面，当前后指针相遇时，即退出
 * 链接：https://leetcode-cn.com/problems/bag-of-tokens/
 */
public class T948{
    public static int bagOfTokensScore(int[] tokens, int power) {
        int len=tokens.length;
        Arrays.sort(tokens);
        //用以标记已经翻过的牌
        boolean[] used=new boolean[len];
        int cnt=0;
        int index=len-1;
        for (int i = 0; i < len; i++) {
            if (!used[i] && power>=tokens[i]){
                power-=tokens[i];
                cnt++;
                used[i]=true;
            }else if(cnt>=1 && !used[i]){
                //当双指针相遇时，退出
                if(i==index){
                    break;
                }
                power+=tokens[index];
                cnt-=1;
                used[index]=true;
                index--;
                i-=1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] tokens={68,25,34,60,85};
        int power=44;
        int res = bagOfTokensScore(tokens, power);
        System.out.println(res);
    }

    public static int bagOfTokensScore1(int[] tokens, int P) {
        Arrays.sort(tokens);
        int lo = 0, hi = tokens.length - 1;
        int points = 0, ans = 0;
        while (lo <= hi && (P >= tokens[lo] || points > 0)) {
            while (lo <= hi && P >= tokens[lo]) {
                P -= tokens[lo++];
                points++;
            }

            ans = Math.max(ans, points);
            if (lo <= hi && points > 0) {
                P += tokens[hi--];
                points--;
            }
        }

        return ans;
    }

}
