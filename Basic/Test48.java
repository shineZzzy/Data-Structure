package 实验报告;

import java.io.*;
import java.util.Scanner;

public class Test48 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String s=scan.nextLine();
            int n=Integer.parseInt(s);
            for(int i=n;i>0;i--)
            {
                for(int j=i+1;j>0;j--){
                    System.out.print("* ");
                }
                for(int j = 0;j<n-i;j++)
                    System.out.print(" ");
                System.out.println();
            }

            for(int i=0;i<=n;i++)
            {
                for(int j=i+1;j>0;j--){
                    System.out.print("* ");
                }
                for(int j=n;j>i;j--)
                    System.out.print(" ");

                System.out.println();
            }
            System.out.println();
        }
    }
}
