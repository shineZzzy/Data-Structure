package EveryDay.offer.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * 思路：将一位数，两位数的都解析出添加到map中
 * 先判断map中是否有字符串中的两位数，有求和，指针向后移两位
 * 没有，再去判断是否存在一位数的，有求和，指针向后移一位
 * 最后返回总和即可。
 * 链接：https://leetcode-cn.com/problems/roman-to-integer/
 */
public class RomanNum {
    public static int romanToInt(String s) {
        Map<String,Integer> map=new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);


        int count=0;
        for (int i = 0; i < s.length();) {
            if (i+1<s.length() && map.containsKey(s.substring(i,i+2))){
                count+=map.get(s.substring(i,i+2));
                i+=2;
            }else {
                if (map.containsKey(s.substring(i,i+1))){
                    count+=map.get(s.substring(i,i+1));
                    i++;
                }
            }
        }
        return count;
    }
}
