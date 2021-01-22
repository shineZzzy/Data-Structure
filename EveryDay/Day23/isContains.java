package Test.T0121;

import java.util.Scanner;

public class isContains {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            String s1=sc.nextLine();

            String[] str=s1.split("");
            String res="";
            for (int i = 0; i <str.length; i++) {
                if (s1.contains(str[i])) {
                    res = "yes";

                }else {
                    res="No";
                }
            }
            System.out.println(res+" "+contains(s, s1,res));
        }
    }
    public static int  contains(String s1,String s2,String s3){
        boolean flag = true;
        int count=0;
        for (int i = 0; i <s2.length() ; i++) {
            if(s3.equals("yes")){
                for (int j=0;j<s1.length();j++){
                    if (s1.charAt(i) != s2.charAt(j)) {
                        count++;
                        break;
                    }
                }
            }else {
                for (int j=0;j<s1.length();j++){
                    if (s1.charAt(i) == s2.charAt(j)) {
                        count++;
                        flag=false;
                    }
                }
            }
        }
        if(flag==false){
            count=s2.length()-count;
        }else {
            count=s1.length()-count;
        }
//        String[] s=s2.split("");
//        char[] c=s1.toCharArray();
//        int count=0;
//        String res="";
//        for (int i = 0; i <s.length; i++) {
//            if(s1.contains(s[i])) {
//                for (int j = 0; j < s1.length(); j++) {
//                    if (s1.charAt(i) != s2.charAt(j)) {
//                        count++;
//                    }
//                }
//            }else {
//                for (int j=0;j<s1.length();j++){
//                    if (s1.charAt(i) == s2.charAt(j)) {
//                        count++;
//                    }
//                }
//            }
//        }
        return count;
    }
}
