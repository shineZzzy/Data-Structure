package 实验报告;
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        String str = scan.nextLine();
//        String[] s = str.split(",");
//        String[] s1=s[0].split("=");
//        String[] s2=s[1].split("=");
//        System.out.println(s1[0]+"="+s2[1]+","+s2[0]+"="+s1[1]);

        Scanner scan=new Scanner(System.in);
        String s1= scan.nextLine();
        String[] s=s1.split(",|=");

        System.out.println("a="+s[1]+","+"b="+s[0]);

    }

}
