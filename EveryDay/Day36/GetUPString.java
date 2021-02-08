package Test.Day36;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GetUPString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            getCount(s);

        }
    }

    private static void getCount(String s) {
        Map<Character,Integer> map=new HashMap<>();
        char[] c=s.toCharArray();
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(i,0);
        }
        for (int i = 0; i <c.length; i++) {
            if (c[i]>='A'&& c[i]<='Z'){
                int count=0;
                Integer v=map.get(c[i]);
                if (v != null){
                    count=v+1;
                }
                map.put(c[i],count);
            }
        }
        for (Map.Entry<Character,Integer> entry:map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
