package offer.String;

/**
 * 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/submissions/
 */

public class replaceBlack1 {
    public static String replaceSpace(String s) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s="we are happy";
        String c= replaceSpace(s);
        System.out.println(c);
    }
}
