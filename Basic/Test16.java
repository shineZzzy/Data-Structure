package 实验报告;

import java.util.Scanner;

public class Test16 {

        public static void main(String[] args)  {
            Scanner scan=new Scanner(System.in);
            String s=scan.nextLine();
            String[] str=s.split(" ");
            int n=Integer.parseInt(str[0]);
            int h=Integer.parseInt(str[1]);
            int m=Integer.parseInt(str[2]);
            int rest=0;
            if(m%h==0) {
                rest=n-m/h;
            }else {
                rest=n-m/h-1;
            }
            System.out.println(rest);
        }
}
