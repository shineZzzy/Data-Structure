package Sort.T524_;

import java.util.*;

/**
 * 通过删除字母匹配到字典里最长的单词
 * 思路：自定义排序+双指针
 * (倒着走，直接从长度最长的入手，在长度降序的基础上，使长度相同的按字典序排，这样就能快速找到第一个)
 * 先对字典中的元素进行排序，如果长度相同，就按字典序升序排，长度不同就按长度降序排
 * 再双指针遍历字典元素和字符串，找出长度最大，且字典序最小的元素。
 * 考察点：自定义排序和双指针
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 */
public class T524_1 {
    public static String findLongestWord(String s,
                                         List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()!=o2.length()) {
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            }
        });
        System.out.println(dictionary);
        char[] c=s.toCharArray();
        int len=dictionary.size();
        for (int k = 0; k < len; k++) {
            int i=0,j=0,n=c.length;
            String str=dictionary.get(k);
            char[] in=str.toCharArray();
            int m=in.length;
            while (i<n && j<m){
                if (c[i]==in[j]){
                    j++;
                }
                i++;
            }
            if(j==m){
                return str;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s= "abce";
        List<String> dictionary= Arrays.asList("abe","abc");
        String res = findLongestWord(s, dictionary);
        System.out.println(res);
    }
}
