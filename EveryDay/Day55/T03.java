package LeetCode.Top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出不重复的最长字串
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class T03 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int res=0;
        int i=0;
        for (int j=0; j < s.length(); j++) {
            char c=s.charAt(j);
            if (map.containsKey(c)){
                i=Math.max(map.get(c),i);
            }
            res=Math.max((j-i+1),res);
            map.put(c,j+1);

        }
        return res;
    }

//    public static int lengthOfLongestSubstring2(String s) {
//        Set<Character> set=new HashSet<>();
//        int res=0;
//        int i=0;
//        for (int j = 0; j < s.length(); j++) {
//            if (set.contains(s.charAt(j))){
//
//            }
//        }
//    }

    public static void main(String[] args) {
        String s="bbabcbb";
        int res=lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
