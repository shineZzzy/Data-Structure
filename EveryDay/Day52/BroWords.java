package EveryDay.Mar.Day9;

import java.util.*;

public class BroWords {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            String[] s=new String[n];
            for (int i = 0; i < n; i++) {
                s[i]=sc.next();
            }
            String key=sc.next();
            int k=sc.nextInt();

            List<String> list=new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                if(isBro(s[i],key)){
                    list.add(s[i]);
                }
            }
            Collections.shuffle(list);
            System.out.println(list.size());
            if (k<list.size()){
                System.out.println(list.get(k-1));
            }
        }
    }

    private static boolean isBro(String s,String key) {
        if (s.equals(key) || s.length()!=key.length()){
            return false;
        }
        char[] c=s.toCharArray();
        char[] k=key.toCharArray();
        Arrays.sort(c);
        Arrays.sort(k);
        for (int i = 0; i < c.length; i++) {
            if (c[i]!=k[i]){
                return false;
            }
        }
        return true;
    }
}
