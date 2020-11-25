package Day2;

import java.util.Scanner;

/**
 * 3空瓶=1瓶水
 * 例：10空=5
 * 方法：9空=3
 * 现在：3空+1空(余)
 * 3空=1
 * 剩余：1+1
 * 3-1=1
 * 3还1
 * 假设有n，可换多少？
 */
public class transmute {
    public static void countFunC(int n){
        int count=0;
        int empty=0;
        int full=0;
        int num=n;
        if(n==1){
            return;
        }
        if(n==2){
            count+=1;//借1
            return;
        }
        if(n>2){
            while (num>2) {
                full = num / 3;
                empty = num % 3;
                count = count + full;

                num=full+empty;
                if(num==2){
                    num+=1;
                }
            }

            System.out.println(count);
        }

    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            if(n==0){
                return;
            }else {
                countFunC(n);
            }
        }
    }
}
