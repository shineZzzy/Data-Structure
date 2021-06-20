package Sort.T524_;

import java.util.*;

/**
 * 通过删除字母匹配到字典里最长的单词
 * 思路：先遍历再排序
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/submissions/
 */
public class T524 {
    public static String findLongestWord(String s,
                                         List<String> dictionary) {
        char[] c=s.toCharArray();
        int n=c.length;
        int len=dictionary.size();
        List<String> res=new ArrayList<>();
        for (int k = 0; k < len; k++) {
            int i=0,j=0;
            char[] inner=dictionary.get(k).toCharArray();
            int m=inner.length;
            while (i<n && j<m){
                if (c[i]==inner[j]){
                    j++;
                }
                i++;
            }
            //添加条件
            //避免样例中的情况发生
            if(j==m){
                res.add(dictionary.get(k));
            }
        }
        System.out.println(res);
        if (res.size()!=0){
            res.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() != o2.length()) {
                        return o2.length() - o1.length();
                    }
                    return o1.compareTo(o2);
                }
            });
            return res.get(0);
        }
        return "";
    }

    public static void main(String[] args) {
//        String s= "abpcplea";
//        List<String> dictionary= Arrays.asList("ale","apple","monkey","plea");
        String s= "abpcplea";
        List<String> dictionary= Arrays.asList("ale","apple","monkey","plea", "abpcplaaa","abpcllllll","abccclllpppeeaaaa");
        String res = findLongestWord(s, dictionary);
        System.out.println(res);
    }


}
