package 实验报告;

import java.util.Scanner;

public class Test45 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        while (scan.hasNext()){
            int a=scan.nextInt();
            int count=0;
            for(int i=a;i>=0;i--) {
                for(int k=0;k<a-i;k++){
                    System.out.print(" ");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
}

