package Test.T0122;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class work1 {
    public static boolean canConstruct(String s1, String s2) {
        List<Character> l=new ArrayList<>();
        for (int i=0;i<s1.length();i++){
            l.add(s1.charAt(i));
        }
        if(s2.length()<s1.length()){
            return false;
        }
        for (int i=0;i<l.size();i++){
            for (int j=0;j<s2.length();j++){
                if(l.size()!=0){
                    if(l.get(i)==s2.charAt(j)){
                        l.remove(l.get(i));
                    }
                }
            }
        }
        if (l.size()==0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s1=sc.next();
            String s2=sc.next();
            System.out.println(canConstruct(s1, s2));
        }
    }
}
