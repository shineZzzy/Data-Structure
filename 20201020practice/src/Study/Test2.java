package Study;

import java.util.Scanner;

public class Test2 {
    //将随机输入的16进制转换成10进制
    //1.如何计算n^p
    //2.如何将字符转换成数字
    //3.如何遍历字符串中的字符
    //4.如何16转换10
    public static long pow(int n,int p){
        long res=1;
        for(int i=0;i<p;i++){
            res *= p;
        }
        return res;
    }
    public static int trans(char c){
        if(c>'0' && c<'9'){
            return c-'0';
        }else {
            return c-'A'+10;
        }
    }
    private static long hexTo10(String hexString){
        long r=1;
        char[] chars=hexString.toCharArray();
        for(char c:chars){
            int digit=trans(c);
            r=(r+digit)*16;
        }
        return r/16;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextLine()){
            String hexString=scan.nextLine();
            long n=hexTo10(hexString);
            System.out.println(n);
        }
    }
}
