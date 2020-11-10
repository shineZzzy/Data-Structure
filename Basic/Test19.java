package 实验报告;
import java.util.Scanner;
//从键盘任意输入一个字符，判断是否是字母（包括大小写）
//多行输入
public class Test19 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=null;
        char c;
        while (scan.hasNext()){
            s=scan.nextLine();
            c= s.charAt(0);
            if(c>='a'&&c<='z'||c>='A'&& c<='Z'){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
