package LeetCode.EveryDAY.WEEK.Week4_String;
import java.util.*;

/**
 * 字母异位词分组
 * 链接：https://leetcode-cn.com/problems/group-anagrams/
 */

public class T49 {
    public static List<List<String>> groupAnagrams(String[] strs) {

        int len=strs.length;
        if (len==0){
            return new ArrayList<>();
        }
        Map<String,List<String>> map=new HashMap<>();
        for (int i = 0; i < len; i++) {
            String s=strs[i];

            char[] c=s.toCharArray();
            Arrays.sort(c);
            //拿出来排序构成新字符串，如果是异构的，key一定相同
            String key=String.valueOf(c);
            List<String> list=new ArrayList<>();
            if (!map.containsKey(key)){
                list.add(s);
           }else {
                list=map.get(key);
                list.add(s);
            }
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String[] str={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagrams(str);
        System.out.println(res);
    }
}
