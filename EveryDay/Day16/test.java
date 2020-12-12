package Day16;

import java.util.Scanner;

/**
 * 这个思路有点复杂，但是是从整体结果推向过程
 * 1.先从结果序列中截取出N
 * 2.再写专门截取的方法，截取各段卡牌信息
 * 3.写专门的截取卡牌方法，从卡牌信息片段截取卡牌。
 * 4.写洗牌方法对各卡牌进行洗牌
 * 问题：在第2步，下标复杂难以确定！
 */
public class test {
    public static String[] subS(String str){
        return str.substring(4).split(" ");
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String str1=s.substring(2,17);
        String str2=s.substring(18,33);
        String str3=s.substring(34,s.length());
        int N=Integer.parseInt(s.substring(0,1));
        //获取卡牌信息
        /**
         * 问题：小标难找！！！
         */

        //获取卡牌部分
        String[] s1=subS(str1);
        String[] s2=subS(str2);
        String[] s3=subS(str3);
        //获取次数

    }
}
