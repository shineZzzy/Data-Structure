package SuanFa.Tanxin;

/**
 *  判断子序列
 *  双指针遍历两个串
 *  链接：https://leetcode-cn.com/problems/is-subsequence/
 */
public class T392 {
    //双指针
    public static boolean isSubsequence(String s, String t) {
        int ls=s.length();
        int lt=t.length();
        if (lt<ls){
            return false;
        }
       int i=0,j=0;
        while (i<ls && j<lt){
            if (s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else {
                j++;
            }
        }

//        if (i<ls && j>=lt){
//            return false;
//        }

        //如果匹配，最后一定是将s串全部遍历完了
        return i==ls;
    }

    public static void main(String[] args) {
        String s="abc";
        String t="ahbgdc";
        boolean res = isSubsequence(s, t);
        System.out.println(res);

    }
}
