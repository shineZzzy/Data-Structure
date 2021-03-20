package EveryDay.Mar.Day12;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * 简单错误记录
 * 这个题是我第二次做，还是一样的看不懂题目描述再说什么，
 * 上次好像也是研究半天示例才看明白，这次也是.....但庆幸的是：尽管错了很多遍，这次我做出来了，耶耶耶！
 * 题意：只取输入的后八条字符串，
 * 对字符串的文件名和行号截取，其他字符串的文件名与行号若是相同就合并为一条
 * 如果文件名长度>16，就只取后16个
 * 输出：按输入顺序输出，文件名 行号 记录用空格间隔
 * 链接：https://www.nowcoder.com/questionTerminal/2baa6aba39214d6ea91a2e03dff3fbeb
 */
public class ErrorWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String file=s.substring(s.lastIndexOf("\\")+1,s.indexOf(" "));
            String row = s.substring(s.indexOf(" ")+1);
            if (file.length()>16){
                file=file.substring(file.length()-16);
            }
            String key=file+" "+row;
            int count=0;
            if (map.containsKey(key)){
                count=map.get(key)+1;
            }else {
                count=1;
            }
            map.put(key,count);
        }
        int count=0;
        for (String s:map.keySet()){
            count++;
            if (count>(map.keySet().size()-8)){
                System.out.println(s+" "+map.get(s));
            }
        }
    }
}
