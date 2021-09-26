package Leet2021_09;

/**
 * 两整数之和
 * 思路：
 * 将 a+b 的问题 划分为 有进位和无进位 的情况来考虑
 * 无进位：异或 获取无进位的结果
 * 有进位：与运算 + 移位
 *        与运算：获取进位
 *        移位：获取进位后的结果
 * 循环上述操作，即为求和结果
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers/
 */
public class T371 {
    public static int getSum(int a, int b) {
        while (b!=0){
            int carry=(a&b)<<1;
            a=a^b;
            b=carry;
        }
        return a;
    }
}
