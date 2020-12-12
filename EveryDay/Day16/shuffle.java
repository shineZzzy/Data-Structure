package Day16;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 洗牌
 * 3  3 1   1 2 3 4 5 6   3 2   1 2 3 4 5 6    2 2 1 1 1 1
 *          1 4 2 5 3 6         1 5 4 3 2 6        1 1 1 1
 */
public class shuffle {
    public static String[] subString(String str){
        return str.substring(4).split(" ");
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String str1=s.substring(2,17);
        String str2=s.substring(18,33);
        String str3=s.substring(34,s.length());
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str1.length());
        int N=Integer.parseInt(s.substring(0,1));
        //现将所有片段分段
        String[] s1=str1.substring(4,str1.length()).split(" ");
        String[] s2=str2.substring(4,str2.length()).split(" ");
        String[] s3=str3.substring(4,str3.length()).split(" ");
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
        System.out.println(Arrays.toString(s3));
        //对第一段处理，取n c
//        int n=Integer.parseInt(s.substring(2,3));
//        int c=Integer.parseInt(s.substring(4,5));
//        System.out.println(N);
//        System.out.println(n);
//        System.out.println(c);
//        //对第二段
//        int n1=Integer.parseInt(s.substring(2,3));
//        int c1=Integer.parseInt(s.substring(4,5));
//        System.out.println(N);
//        System.out.println(n1);
//        System.out.println(c1);


    }
}
