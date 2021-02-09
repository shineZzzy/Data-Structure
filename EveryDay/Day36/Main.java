package Test.Day36;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
//摘自牛客解答
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        Iterator it = calc(str).entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry ent=(Map.Entry)it.next();
            System.out.println(ent.getKey() + ":" + ent.getValue());
        }
    }
    public static TreeMap<Character, Integer> calc(String str) {
        char[] chars = str.toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                int count = 0;
                Integer value = map.get(chars[i]);
                if (value != null) {
                    count = value + 1;
                }
                map.put(chars[i], count);
            }
        }
        return map;
    }
}





