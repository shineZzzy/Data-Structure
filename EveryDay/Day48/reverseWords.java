package EveryDay.Mar.Day4;
import java.util.Scanner;

/**
 *  句子反转
 *  给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。
 * 链接：https://www.nowcoder.com/questionTerminal/0ae4a12ab0a048ee900d1536a6e98315
 */
public class reverseWords {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            isReverse2(s);
        }

    }

    private static void isReverse(String s) {
        String[] str=s.split(" ");
        int i=0;
        int j=str.length-1;
        while (i<j){
            swap(str,i,j);
            i++;
            j--;
        }
        StringBuilder sb=new StringBuilder();
        for (int k = 0; k < str.length; k++) {
            if (k==str.length-1){
                sb.append(str[k]);
            }else {
                sb.append(str[k]).append(" ");
            }

        }
        System.out.println(sb.toString());

    }


    private static void swap(String[] str, int i, int j) {
        String temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }

    private static void isReverse2(String s) {
        StringBuilder sb=new StringBuilder();
        String[] str=s.split(" ");
        for (int i = str.length-1; i >=0 ; i--) {
            sb.append(str[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
