package LeetCode.Sort;

import java.util.Arrays;

/**
 * LeetCode242 有效的字母异位词
 * 链接：https://leetcode-cn.com/problems/valid-anagram/
 */
public class T242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] c1=s.toCharArray();
        char[] c2=t.toCharArray();
        int[] n1 = ArraySort(c1);
        int[] n2 = ArraySort(c2);
        int i=0;
        int j=0;
        while (i<n1.length && j<n2.length){
            if(n1[i]!=n2[j]){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    private static int[] ArraySort(char[] c2) {
        int[] n=new int[c2.length];
        for (int i = 0; i < c2.length; i++) {
            n[i]=c2[i];
        }
        Arrays.sort(n);
        return n;
    }

    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";
        boolean res = isAnagram(s, t);
        System.out.println(res);
    }
}
