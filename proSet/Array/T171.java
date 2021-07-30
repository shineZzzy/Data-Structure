package LeetCode1.EveryDAY.Array;

/**
 * Excel表列序号
 * 26个字母看出26进制，每26个进1位
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class T171 {
    public static int titleToNumber(String s) {
        char[] charArray = s.toCharArray();
        int res = 0;
        for(int i = 0; i < charArray.length; i++) {
            //计算其代表的数值
            int num=charArray[i] - 'A' + 1;
            //26进制,每 26 个数则向前进一位
            res = res*26 + num;
        }
        return res;
    }

    public static void main(String[] args) {
        String s="FXSHRXW";
        int res = titleToNumber(s);
        System.out.println(res);

    }
}
