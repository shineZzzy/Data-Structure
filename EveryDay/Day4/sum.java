package Day4;

import java.util.Scanner;

public class sum {
    public static int count(int n){
        if(n%6==0){
            return n/6;
        }else if(n%8==0){
            return n/8;
        }else if(n%2!=0||n<6||n==10){
            return -1;
        }
        return 1+n/8;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        System.out.println(count(n));
    }
}
