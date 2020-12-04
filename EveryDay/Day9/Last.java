package Day9;

import java.util.Scanner;

public class Last {
    public static int countN(long r){
        int count=0;
        if(r>=5) {
            while (r % 10 == 0) {
                count++;
                r = r / 10;
            }
        }
        return count;
    }
    public static long resN(int n){

        if(n==0||n==1){
            return 1;
        }
        return n*resN(n-1);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int n=scan.nextInt();
            long res=resN(n);
            System.out.println(countN(res));
        }
    }
}
