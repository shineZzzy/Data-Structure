package Test.Day42;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数
 */
public class Atoi {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;

        //第一个for循环是把符合要求的整数构造出来并存倒StringBuilder里
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == ' ' && sb.length() == 0) {
                continue;
            } else if ((cur == '+' || cur == '-') && sb.length() == 0) {
                sb.append(cur);
            } else if (cur >= 48 && cur <= 57) {
                sb.append(cur);
            } else {
                break;
            }
        }
        //当字符串构造不出来符合条件的整数时直接返回0
        if (sb.length() == 0) return 0;

        //下面的逻辑就是要把字符串例如"12345" 转换为整数 12345
        int result = 0;
        boolean flag = true;
        int i = 0;
        if (sb.charAt(0) == '+') {
            flag = true;
            i = 1;
        } else if (sb.charAt(0) == '-') {
            flag = false;
            i = 1;
        }

        while (i < sb.length()) {
            int temp = sb.charAt(i) - '0';
            //这两个判断非常重要，如果溢出就直接返回
            if (flag == true && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7))) {
                return Integer.MAX_VALUE;
            } else if (flag == false && (result > Math.abs(Integer.MIN_VALUE / 10) || (-result == Integer.MIN_VALUE / 10 && temp > 8))) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + temp;
            i++;
        }

        //最终结果
        if (flag == true) return result;
        else return -result;
    }
}

//力扣网友解法：https://leetcode-cn.com/problems/string-to-integer-atoi/solution/javaji-bai-99de-yong-hu-xiao-xue-sheng-du-neng-kan/