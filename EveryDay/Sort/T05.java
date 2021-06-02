package offer.week1;

/**
 * 替换空格
 * 题意：把字符串 s 中的每个空格替换成"%20"
 *
 */
public class T05 {
    public static String replaceSpace(String s) {
        int len=s.length();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="we are pkp";
        String s1 = replaceSpace(s);
        System.out.println(s1);
    }
}

