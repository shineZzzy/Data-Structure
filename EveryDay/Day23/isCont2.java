package Test.T0121;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class isCont2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String s1 = sc.nextLine();
            contain(s,s1);
        }
    }
    public static void contain(String s,String s1){
        List<Character> l=new ArrayList<>();
        int count=0;
        boolean flag=false;
//        int[] n=new int[s1.length()+1];
        for (int i=0;i<s.length();i++){
            l.add(s1.charAt(i));
        }
        for (int j=0;j<s1.length();j++){
            for (int i=0;i<s.length();i++){
                if(s.charAt(j)==s1.charAt(i)){
                    l.remove(s1.charAt(i));
                    count++;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("No "+count);
        }else {
            System.out.println("Yes "+(s.length()-count));
        }
    }
}
