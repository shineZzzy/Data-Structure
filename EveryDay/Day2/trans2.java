package Day2;

import java.util.Scanner;

public class trans2 {
    public static void countFunC(int n) {
        int count = 0;
        int num = n;
        while (num > 0) {
            if (num == 1) {
                return;
            } else if (num == 2) {
                num += 1;//借1
                continue;
            } else {
                while (num > 2) {
                    count += num/3;
                    num = num/3 + num%3;
                }
                System.out.println(count);
            }

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
