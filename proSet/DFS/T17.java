package LeetCode1.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * 题意：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 思路：回溯，以第一个字符为首，遍历字符对应的每个字母，与第二个字符中的字母进行排列组合。
 * 和全排列一样，只是多了一组数。
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class T17 {
    public static List<String> letterCombinations(String digits) {
        int len=digits.length();
        List<String> res=new ArrayList<>();
        if (len==0){
            return res;
        }
        StringBuilder path=new StringBuilder();
        Map<Character,String> map=new HashMap<>();
        map.put('1',"!@#");
        map.put('2',"abc");
        map.put('3',"edf");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        dfs(digits,len,0,path,map,res);
        return res;
    }

    private static void dfs(String digits, int len,
                            int begin, StringBuilder path,
                            Map<Character, String> map,
                            List<String> res) {

        if (path.length()==len){
            res.add(new String(path));
            return;
        }
        //获取字符串中的字符，并从map中得出映射字母
        char c=digits.charAt(begin);
        char[] a=map.get(c).toCharArray();
        int n=a.length;
        for (int i = 0; i < n; i++) {
            path.append(a[i]);
            System.out.println("befor:--->"+path);
            //与下一个字符的各字母进行组合
            dfs(digits,len,begin+1,path,map,res);
            path.deleteCharAt(begin);
            System.out.println("after:--->"+path);
        }
    }

    public static void main(String[] args) {
        String s="23";
        List<String> res = letterCombinations(s);
        System.out.println(res);
    }
}
