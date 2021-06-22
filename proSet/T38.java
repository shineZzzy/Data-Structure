package LeetCode1.dfs;

import java.util.*;

/**
 * 字符串的排列
 * 字符串的全排列
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class T38 {
    public static String[] permutation(String s) {
        int len=s.length();
        if (len==0){
            return null;
        }
        List<String> res=new ArrayList<>();
        StringBuilder path=new  StringBuilder();
        boolean[] used=new boolean[len];
        char[] c=s.toCharArray();
        int n=c.length;
        Arrays.sort(c);
        dfs(c,n,path,used,res);
        String[] ret=new String[res.size()];
        int i=0;
        for (String str : res) {
            ret[i++]=str;
        }
        return ret;
    }

    private static void dfs(char[] c, int len,
                            StringBuilder path,
                            boolean[] used, List<String> res) {
        if (path.length()== len){
            res.add(String.valueOf(path));
            return;
        }

        for (int i = 0; i <len; i++) {
            if (used[i] || (i>0 && c[i]==c[i-1] && !used[i-1]) ){
                continue;
            }
            path.append(c[i]);
            System.out.println("befor--->"+path);
            used[i]=true;
            dfs(c,len,path,used,res);
            path.deleteCharAt(path.length()-1);
            System.out.println("after--->"+path);
            used[i]=false;
        }
    }

    public static void main(String[] args) {
        String s="aba";
        String[] res = permutation(s);
        System.out.println(Arrays.toString(res));
    }
}
