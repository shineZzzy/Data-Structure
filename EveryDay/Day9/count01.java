package Day9;

import java.util.Scanner;
public class count01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for(int i = n; i>=5; i--) {
            int tmp = i;
            while(tmp%5==0) {
                count++;
                tmp/=5;
            }
        }
        System.out.println(count);
    }
}

