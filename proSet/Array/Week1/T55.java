package SuanFa.Tanxin;

/**
 * 跳跃游戏
 * 思路：枚举每个位置，维护当前位置可以跳跃的最远位置，
 * 如果该位置可以到达末尾，即符合条件
 * 链接：https://leetcode-cn.com/problems/jump-game/
 */
public class T55 {
    public static boolean canJump(int[] nums) {
        int len=nums.length;
        int i=0,dist=0;
        while (i<len && i<=dist){
            //更新最远距离
            dist=Math.max(dist,nums[i]+i);
            //如果该位置已经满足条件了，直接返回
            if(dist>=len-1){
                return true;
            }
            i++;

        }
//        return dist>=len-1;
        return false;
    }

    public static void main(String[] args) {
        int[] nums={2,0,0};
        boolean res = canJump(nums);
        System.out.println(res);
    }
}
