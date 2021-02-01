package Test.Day31;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class error2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            getErrorCount(s);
        }
    }

    private static void getErrorCount(String s) {
        String[] str=s.split("\\\\");
        String key=str[str.length-1];
        String line=key.substring(key.indexOf(" ")+1);//
        Map<String ,String> map=new HashMap<>();

    }
}
