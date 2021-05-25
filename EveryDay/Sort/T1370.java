package K;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * T1370 上升下降字符串
 * 题意
     * 选出最小的字母，追加到结果字符串
     * 选出第二小的字母，追加到结果字符串
     * 每次都比上次大，重复下去，直到没有比上次大的字母
     * 选出最大的字母，追加到结果字符串
     * 选出第二大的字母，追加到结果字符串
     * 每次都比上次小，重复下去，直到没有比上次小的字母
     * 重复 1~6，直到选完所有字符
 * 思路：桶排序
 * 只关注字符本身，而不关注字符在原字符串中的位置
 * 1.用大小为26的数组，记录字符串中字母出现的次数
 * 2.先顺序遍历取最小值，在逆序遍历取最大值
 * 3.直到答案字符串的长度与传入的字符串的长度相等

 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string/solution/tu-jie-du-dong-ti-mu-jiu-hui-liao-1370shang-sheng-/
 */
public class T1370 {
    //繁琐的不能在繁琐了！
    public static String sortString1(String s) {
        if (s.length() == 0){
            return null;
        }
        char[] c=s.toCharArray();
        Arrays.sort(c);
        List<Character> list=new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            list.add(c[i]);
        }

        StringBuilder sb=new StringBuilder();
        while (!list.isEmpty()) {
            int i=0;
            sb.append(list.get(i));
            list.remove(i);
            while (i<=list.size()-1){
                if (list.get(i)>sb.charAt(sb.length()-1)){
                    sb.append(list.get(i));
                    list.remove(i);
                }else {
                    i++;
                }
            }
            int j=list.size()-1;
            if (j<0){
                break;
            }else {
                sb.append(list.get(j));
                list.remove(j);
                j-=1;
            }

            while (j>=0){
                if(list.get(j)<sb.charAt(sb.length()-1)){
                    sb.append(list.get(j));
                    list.remove(j);
                }
                j--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1="aaaabbbbcccc";
        String s2="rat";
        String s="leetcode";

        String res = sortString(s2);
        System.out.println(res);

    }
    //官解
    public static String sortString(String s) {
        int[] num=new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        while (sb.length()<s.length()){
            for (int i = 0; i < 26; i++) {
                if (num[i]>0){
                    sb.append((char)(i+'a'));
                    num[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (num[i] > 0) {
                    sb.append((char) (i + 'a'));
                    num[i]--;
                }
            }
        }
        return sb.toString();
    }
}
