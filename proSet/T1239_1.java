package LeetCode1.EveryDAY;

import java.util.*;

/**
 * 串联字符串的最大长度
 * 注意：如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class T1239_1 {
    public static int res=0;
    public static int maxLength(List<String> arr) {
        int len=arr.size();
        StringBuilder path=new StringBuilder();
        dfs(arr,len,0,path);
        return res;
    }
    private static void dfs(List<String> arr, int len, int begin,
                            StringBuilder path) {
        char[] c=path.toString().toCharArray();
        Set<Character> set=new HashSet<>();
        for (char value : c) {
            if (set.contains(value)) {
                return;
            } else {
                set.add(value);
            }
        }

        res=Math.max(res,path.length());
        for (int i = begin; i < len; i++) {
            path.append(arr.get(i));
            dfs(arr,len,i+1,path);
            path.delete(path.length()-arr.get(i).length(),path.length());

        }
    }

    public static void main(String[] args) {
        List<String> arr=Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p");
        System.out.println(maxLength(arr));
    }
}
