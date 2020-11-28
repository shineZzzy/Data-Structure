package Day4;

import java.util.Scanner;

public class sum2 {
    public static int count(int n){

        int x=n/8;
        if(n%6==0){
            return n/6;
        }else if(n%8==0){
            return n/8;
        }else if(n>10 && n%2==0){
            return x+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        System.out.println(count(n));
    }
}
