package Test.Day28;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度大于2的子串重复
 * 牛客链接：https://www.nowcoder.com/questionTerminal/184edec193864f0985ad2684fbc86841
 */
public class password {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            isRight(s);
        }
    }

    private static void isRight(String s) {

        int NumFlag=0;
        int UpFlag =0;
        int LowFlag=0;
        boolean LenFlag=false;
        int UniFlag=0;
        String unique="[ _`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\\n|\\r|\\t";
        if (s.length() >=8){
            LenFlag=true;
        }
        for (int i = 0; i <s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                NumFlag=1;
            } else if(Character.isUpperCase(s.charAt(i))){
                UpFlag=1;
            } else if(Character.isLowerCase(s.charAt(i))){
                LowFlag=1;
            } else if (isFile(s)){
                UniFlag=1;

            }
        }

        int sum=NumFlag + UpFlag + UniFlag + LowFlag;
        if (sum>=3 && LenFlag && !isRepeat(s)){
            System.out.println("OK");
        }else {
            System.out.println("NG");
        }
    }

    private static boolean isRepeat(String s) {
        //不包含为true
        boolean flag=false;
        for (int i = 0; i < s.length()-2; i++) {
            String str=s.substring(i,i+3);
            if (s.substring(i+1).contains(str)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean isFile(String s){
        String regex = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！ @#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regex );
        Matcher matcher = p.matcher(regex );
        return matcher.find();

    }

}
