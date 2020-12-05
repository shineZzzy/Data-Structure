package Day10;

import java.util.Scanner;

public class robert2 {
    public static int countWays(int x, int y) {
        // 是走格子不是走边!!!
        //2*2=(1*2)+(2*1)
        if(x==1 || y==1){
            return 1;
        }
        return countWays(x,(y-1))+countWays((x-1),y);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int x=scan.nextInt();
        int y=scan.nextInt();
        System.out.println(countWays(x, y));
    }
}
