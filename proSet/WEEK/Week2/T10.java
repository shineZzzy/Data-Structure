package LeetCode.剑指offer.Week2;

/**
 * 斐波那契数列
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class T10 {
    public int fib(int n) {

        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
