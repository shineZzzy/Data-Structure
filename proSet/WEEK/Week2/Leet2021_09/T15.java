package Leet2021_09;

/**
 * 二进制中1的个数
 * 思路：位运算
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class T15 {
    public static void main(String[] args) {
        int n=5;
        int res = hammingWeight(n);
        System.out.println(res);
    }

    /**
     * 方法1：
     * 将n 和 n-1 进行与运算，获取 1 的个数
     * 直至 n==0
     */
    public static int hammingWeight_1(int n) {
        int count=0;
        while (n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }

    //方法2：与运算 统计最低位为1的个数
    //将n右移，在最高位补0，将n这的1都往最低位移动
    //循环往复，直至n==0，即统计完所有1
    public static int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n & 1);
            n >>>= 1;
        }
        return ans;
    }

}
