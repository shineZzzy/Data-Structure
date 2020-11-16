package 实验报告;

import java.util.Scanner;

//KiKi想完成字母大小写转换，有一个字符，
//判断它是否为大写字母
//如果是，将它转换成小写字母；
//反之则转换为大写字母
public class Test31 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String s=scan.nextLine();
            char c=s.charAt(0);
            if(c>'a'&&c<'z'){
                System.out.println(s.toUpperCase());
            }else if(c>'A'&& c<'Z'){
                System.out.println(s.toLowerCase());
            }else {
                System.out.println("输入有误！");
            }

        }
    }
}
