package Sloution.百度;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/***
 * 字符串中最长的不重复子串
 * 返回：不重复的子串及其长度
 * 思路：
     * 1.遍历整个数组，用map存储元素，及其下标
     * 2.如果当前元素在map中已有了，则获取上一次它出现的下标，代表新子串的出现
     * 3.通过当前下标-上次的下标，中间的间隔即为不重复字串的长度
     * 4.遍历过程中，记录当前最长不重复子串，并更新最大长度，直到数组遍历完毕
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class T48 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String res=findMaxLength(str);
        System.out.println(res);
        System.out.println(res.length());
    }

    private static String findMaxLength(String str) {
       int len=str.length();
       if (len==0){
           return null;
       }
       int res=0;
       int index=0;
       String ret="";
       Map<Character,Integer> map=new HashMap<>();
       char[] ch=str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])){
                index=map.get(ch[i]);
            }

            map.put(ch[i],i);
            if (i-index>res){
                ret=str.substring(index,i);
            }
            res=Math.max(res,i-index);

        }

        return ret;
    }
}
