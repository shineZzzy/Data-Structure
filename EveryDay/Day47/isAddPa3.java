package EveryDay.Mar.Day3;
import java.util.Scanner;

/**
 * 回文串
 * 给定一个字符串，问是否能通过添加一个字母将其变为回文串。
 * 思路：可以增加一个构成回文，那也可以减少一个构成回文，删减头和尾，然后遍历整个串，但凡遇到一组不相同，则不是。
 * 链接：https://www.nowcoder.com/questionTerminal/655a43d702cd466093022383c24a38bf
 */
public class isAddPa3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            isPalindrome(s);
        }
    }

    private static void isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        boolean flag=false;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                if (s.charAt(i+1)==s.charAt(j)){
                    i++;
                }else if (s.charAt(i)==s.charAt(j-1)){
                    j--;
                }else {
                    flag=false;
                    break;
                }
                flag=true;
            }else {
                i++;
                j--;
                if (s.charAt(i)!=s.charAt(j)){
                    flag=false;
                    break;
                }
                flag=true;
            }
        }
        if (flag){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
