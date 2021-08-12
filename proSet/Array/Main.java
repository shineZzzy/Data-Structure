package kkk;
import java.util.*;

/**
 * 找出一个字符串中所有长度>=3的回文串
 * 虾皮二面面试题，不难的，想到用双指针和截取的方式，结果没写出来，说到底还是没有理解到位
 */


public class Main{
    public static void main(String[] args){
        String s="abcbaaba";
        List<String> list=huiwen(s);
        System.out.println(list);
    }

    public static List<String> huiwen(String s){
        List<String> list=new ArrayList<>();
        int len=s.length();
        if(len==0){
            return list;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                //截取字串，判断是否是回文串
                String str=s.substring(i,j);
                if (isHuiwen(str) && !list.contains(str)){
                    list.add(str);
                }
            }
        }
        return list;
    }

    private static boolean isHuiwen(String str) {

        int len=str.length();
        //将长度小于3的都排除掉
        if(len<3){
            return false;
        }

        int l=0,r=len-1;
        while (l<r){
            if (str.charAt(l)==str.charAt(r)){
                l++;
                r--;
            }else {
                return false;
            }
        }
        return true;
    }

}
