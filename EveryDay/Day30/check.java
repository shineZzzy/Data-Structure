package Test.Day30;

import java.util.Scanner;

/**
 * 奇偶校验
 * 思路：1.将字符转化为 ASCII 码
 * 2.将ASCII值转换为二进制，利用Integer.toBinaryString()方法
 * 3.补二进制为7位
 * 4.遍历检查”1“的个数，如果为奇数，则校验位为0，反之为1.
 * 5.根据测试用例得知，校验位处于最高位，
 * 6.因此在根据count的奇偶，利用字符串拼接完成校验位添加
 *
 * bug:count的位置，也会影响结果！
 */
public class check {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            getCheck(s);
        }
    }
    private static void  getCheck(String s) {

        char[] array = s.toCharArray();
        for (char c : array) {
            int count = 0;
            String s1 = Integer.toBinaryString(c);
            String s2 = String.format("%07d", Integer.parseInt(s1));
            for (int j = 0; j < 7; j++) {
                if (s2.charAt(j) == '1') count++;
            }
            System.out.println(count % 2 == 0 ? "1" + s2 : "0" + s2);
        }
    }
}
