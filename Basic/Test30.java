package 实验报告;

import java.util.Scanner;

/**
 * 有五个字母A(a), E(e), I(i), O(o),U(u)称为元音，
 * 其他所有字母称为辅音，
 * 请帮他编写程序判断输入的字母
 * 是元音（Vowel）还是辅音（Consonant）。
 */
public class Test30 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String s=scan.nextLine();
            char c=s.charAt(0);
            if(c=='A'||c=='a' ||c=='E'|| c=='e'||c=='I'||c=='i'||c=='O'||c=='o'||c=='U'||c=='u'){
                System.out.println("Vowel");
            }else {
                System.out.println("Consonant");
            }
        }
    }
}
