package Leet2021_09.T20;

/**
 * 表示数值的字符串
 * 思路：按条件注意判断...if-else
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 */
public class T20 {
    public static boolean isNumber(String s) {
        int len=s.length();
        if (len==0){
            return false;
        }
        String[] str=s.split(",");
        boolean isNum=false,isDone=false,isE=false;
        for (String strs : str) {
            char[] ch=strs.trim().toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i]>='0' && ch[i]<='9'){
                    isNum=true;
                }else if (ch[i]=='.'){
                    if (isDone || isE){
                        return false;
                    }
                    isDone=true;
                }else if (ch[i]=='e'|| ch[i]=='E'){
                    if (!isNum|| isE){
                        return false;
                    }
                    isE=true;
                    isNum=false;
                }else if (ch[i]=='-'||ch[i]=='+'){
                    if (i!=0 && ch[i-1]!='e'&& ch[i-1]!='E'){
                        return false;
                    }

                }else {
                    return false;
                }

            }
        }
        return isNum;
    }
}
