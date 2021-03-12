package EveryDay.Mar.Day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 删除字符串中相同的字符
 * 复杂度比较高
 */
public class deleteChar1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            String s1=sc.nextLine();
            isDelete(s,s1);
        }
        
    }

    private static void isDelete(String s1, String s2) {
        List<Character>list=new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            list.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if (list.contains(s2.charAt(i))){
                list.removeAll(Collections.singleton(s2.charAt(i)));
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int k = 0; k < list.size(); k++) {
            sb.append(list.get(k));
        }
        System.out.println(sb.toString());
    }
}
