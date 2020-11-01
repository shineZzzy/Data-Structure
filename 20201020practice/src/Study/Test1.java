package Study;

import java.util.Scanner;

public class Test1 {
    //n^p
    public static long pow(int n,int p){
        int res = 1;
        for(int i=0;i<p;i++){
            res *= n;
        }
        return res;
    }
    //遍历字符串中的每个字符，并转换求解
    private static long hexTo10(String hexString){
        long r = 0;
        char[] chars=hexString.toCharArray();
        for(char c:chars){
            int digit=trans(c);
            r=(r+digit)*16;
        }
        return r/16;
    }
    //将字符转成数字
    public static int trans(char c){
        if(c>'0'&& c<'9'){
            return c-'0';
        }else {
            return c-'A'+10;
        }
    }

    public static void main(String[] args) {
//        long n=pow(2,3);
//        System.out.println(n);
        //16进制转10进制
        //long m=10*16^n;
        //ABCDEF
//        long m=10*pow(16,5)+11*pow(16,4)+12*pow(16,3)+13*pow(16,2)+14*pow(16,1)+15*pow(16,0);
//        System.out.printf("%15d\n",m);
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextLine()) {
            String hexString =scan.nextLine();
            long n=hexTo10(hexString);
            System.out.println(n);
        }
    }
}
