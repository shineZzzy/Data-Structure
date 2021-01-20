package Test.T0119;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransom,能不能由第二个字符串magazines里面的字符构成。
 * 如果可以构成,返回 true;否则返回 false。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * aab
 * baa
 */
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

                    if(l.get(i)==s2.charAt(j)){
                        l.remove(l.get(i));
                        break;
                    }


//                    System.out.println(l);


            }
        }
        if (l.size()==0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s1="aab";
        String s2="baa";
        System.out.println(canConstruct(s1,s2));
//        canConstruct(s1,s2);
    }
}
