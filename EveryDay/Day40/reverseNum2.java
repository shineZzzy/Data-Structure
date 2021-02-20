package Test.Day40;

/**
 *  整数反转
 *  给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 *
 */
public class reverseNum2 {
    public static int reverse(int x) {
        int res=0;
        while (x!=0){
            int t=x%10;
            x /=10;
            //边界限制
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && t > 7)){
                return 0;
            }
            if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 && t < -8)){
                return 0;
            }
            // if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && t > Integer.MAX_VALUE % 10)){
            //                rev = 0;
            //                break;
            // }else if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && t < Integer.MIN_VALUE % 10)){
            //                rev = 0;
            //                break;
            // }
            res=res*10+t;
        }
        return res;
    }
}
