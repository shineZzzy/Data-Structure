package Leet2021_09.T16;

/**
 *  数值的整数次方
 *  思路：
 *  当 n<0 时：把问题转化至 n≥0 的范围内，即执行 x=1/x，n=−n
 *  循环计算：当 n=0 时跳出；
     * 当 n&1=1 时：将当前 x乘入res （即 res∗=x ）；
     *     执行 x = x^2
     *   （即 x *= x ）；
     * 执行 n 右移一位（即n>>=1）。
 *  链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class T16 {
    public static double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
