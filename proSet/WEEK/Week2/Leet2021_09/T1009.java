package T10_09;

import java.util.HashMap;
import java.util.Map;

/**
 * sjfgskshf()(dadadaa)(()("
 * 返回字符串里成对括号内的最长字符串长度
 */
public class T1009 {

    public static void main(String[] args) {
        String str="sjfgskshf()(dadadaa)(()(";
        String s1="";
        String s2="(((((())))))";
        String s3="(12344556";
        String s4="1111111111";
        String s5="1111111111)";
        String s6="(((((((((((";
//        String s7="(123)(2345)(3456)";
        String s8="((12334566785)";

//        int res = maxLength(str);
//        int r1 = maxLength(s1);
//        int r2 = maxLength(s2);
//        int r3 = maxLength(s3);
//        int r4 = maxLength(s4);
//        int r5 = maxLength(s7);
        int r6 = maxLength(s8);
//        System.out.println("res:"+res);
//        System.out.println("r1:"+r1);
//        System.out.println("r2::"+r2);
//        System.out.println("r3:"+r3);
//        System.out.println("r4:"+r4);
//        System.out.println("r5:"+r5);
        System.out.println("r6:"+r6);
    }
    public static int maxLength(String str){
        int len=str.length();
        if (len==0){
            return 0;
        }
        Map<Character,Integer> map=new HashMap<>();
        int i=0;
        int max=0;
        char[] ch=str.toCharArray();
        while (i<len){
            if (ch[i]=='('){
                map.put(ch[i],i);
                i++;
                int cnt=0;
                while (i<len && ch[i]!=')' ){

                    while (i<len && ch[i]=='('){
                        i++;
                    }
                    if (ch[i]!=')' ){
                        cnt++;
                        i++;
                    }
                }
                if (i<len && ch[i]!=')' || i==len){
                    break;
                }
                max=Math.max(max,cnt);
            }else {
                i++;
            }
        }
        return max;
    }
}
