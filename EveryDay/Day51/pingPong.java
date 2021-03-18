package EveryDay.Mar.Day8;

import java.util.*;

/**
 * 乒乓球框
 */
public class pingPong {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String A=sc.next();
            String B=sc.next();
            boolean res=isBInA(A,B);
            if (res){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    private static boolean isBInA(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            int count = 1;
            if (map.containsKey(a.charAt(i))) {
                count++;
            }
            map.put(a.charAt(i), count);
        }
        Map<Character, Integer> mapB = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            int count = 1;
            if (mapB.containsKey(b.charAt(i))) {
                count++;
            }
            mapB.put(b.charAt(i), count);
        }
        int sign=0;
        for (int i = 0; i < mapB.size(); i++) {
            if (map.containsKey(b.charAt(i))) {
                Integer vA = map.get(b.charAt(i));
                Integer vB = mapB.get(b.charAt(i));
                if (vA < vB) {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
