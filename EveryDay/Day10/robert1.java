package Day10;

import java.util.Scanner;

/**
 * a*b的网格中，从左上角走到右下角，只能向右或向下走，求走法？
 * 思路：递归
 */
public class robert1 {
    public static int countWays(int x, int y) {
        // 按边走
        if(x<=0 || y<=0){
            return 1;
        }
        if(x==1 && y==1){
            return 2;
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
