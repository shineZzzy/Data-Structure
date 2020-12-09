package Day13;

import java.util.Scanner;

public class draw4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        int line=n/2;
        if(n%2!=0){
            line=line+1;
        }

            for (int i = 0; i < n; i++) {
                System.out.print(s);
            }
            System.out.println();
            for(int j=0;j<line-2;j++){
                System.out.print(s);
                for (int k=0;k<n-2;k++){
                    System.out.print(" ");
                }
                System.out.print(s);
                System.out.println();
            }
            for (int i = 0; i < n; i++) {
                System.out.print(s);
            }
    }
}
