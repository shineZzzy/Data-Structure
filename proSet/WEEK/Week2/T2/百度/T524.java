package Sloution.T1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 寻找最长子串
 */
public class T524 {
    public static String findLongestWord(String s, List<String> dictionary) {
        int len=s.length();
        if (len==0){
            return s;
        }
        List<String> list=new ArrayList<>();
        for (String str : dictionary) {
            String inner=str;
            char[] ch=inner.toCharArray();
            int n=ch.length;
            int i=0,j=0;
            while (i<s.length() && j<n){
                if (s.charAt(i)==ch[j]){
                    i++;
                    j++;
                }else {
                    i++;
                }

            }

            if(j==n){
                list.add(inner);
            }
        }
        if (list.size()!=0){
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length()!=o2.length()){
                        return o2.length()-o1.length();
                    }
                    return o1.compareTo(o2);
                }
            });

            return list.get(0);
        }
        return "";
    }
}
