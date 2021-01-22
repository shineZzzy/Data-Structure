package Test.T0121;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class isCont3 {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s1=sc.next();
            String s2=sc.next();
            contains(s1,s2);
        }
    }
    public static void contains(String s1,String s2){
        int count=0;
        List<Character> l1=new ArrayList<>();
        List<Character> l2=new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            l1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            l2.add(s2.charAt(i));
        }
        for (int i = 0; i <l2.size(); i++) {
            for (int j=0;j<l1.size();j++){
                if(l1.get(i)==l2.get(j)){
                    l1.remove(l1.get(i));
                    count++;
                    break;
                }
            }
        }

        if(count==l2.size()) {
            System.out.print("Yes"+" "+(s1.toCharArray().length-l2.size()));
        }
        else {
            System.out.print("No" + " " + (l2.size() - count));
        }

    }
}
