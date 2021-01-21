package Test.T0120;

import java.util.Scanner;

public class reverse {
    public static String translate(String s){
        char[] c=new char[s.length()];
        int n=0;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)>='A'&& s.charAt(i)<='Z'){
                if(s.charAt(i)>='F'&& s.charAt(i)<='Z') {
                    n = Integer.valueOf(s.charAt(i));
                    c[i] = (char) (n - 5);
                }else if(s.charAt(i)>='A'&& s.charAt(i)<='E'){
                    n = Integer.valueOf(s.charAt(i));
                    c[i] = (char) (n + 21);
                }
            }else {
                c[i]=s.charAt(i);
            }
        }
//        return Arrays.toString(c);
        return String.valueOf(c);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            String str=translate(s);
            System.out.println(str);
        }
    }
}
