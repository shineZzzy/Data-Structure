package LeetCode.剑指offer.Week1.T61;
import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * 思路：大王小王是万能替补，给数组整体排序后，看相邻元素之间的差值，若是在万能替补个数范围内，则是顺子，反之不是
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class T61 {
    public static boolean isStraight(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        int cnt=0,sum=0;
        for (int i = 0; i < len-1; i++) {
            //统计万能替补个数
            if (nums[i]==0){
                cnt++;
            }else{
                //统计相邻元素的差值
                int v=nums[i+1]-nums[i];
                //若遇到相等的数，则不是顺子
                if (v==0){
                    return false;
                }else if (v>1){
                    sum+=v-1;
                }
            }
        }
        return cnt>=sum;
    }

    public static void main(String[] args) {
//        int[] nums={0,1,2,5,6};
        int[] nums={9,10,4,0,9};
        boolean res = isStraight(nums);
        System.out.println(res);
    }
}
