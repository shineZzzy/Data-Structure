package Test.Day34;

import java.util.*;

public class getKey3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            List<Character> list=getChar(s1,s2);
            for (Character c:list) {
                System.out.println(c);
            }
        }
    }

    public static List<Character> getChar(String s1, String s2) {

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        char[] c1 = s1.toUpperCase().toCharArray();
        char[] c2 = s2.toUpperCase().toCharArray();

        for (int i = 0; i < c1.length; i++) {
            if (!m1.containsKey(c1[i])) {
                m1.put(c1[i], i);
            }
        }

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < c2.length; i++) {
            if (!m1.containsKey(c2[i])) {
                if (!m2.containsKey(c2[i])) {
                    m2.put(c2[i], i);
                    list.add(c2[i]);
                }
            }
        }
        return list;
    }
}
