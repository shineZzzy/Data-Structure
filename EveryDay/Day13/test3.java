package Day13;

import java.math.BigInteger;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while (s.hasNext()) {
            String a = s.nextLine();
            String b = s.nextLine();

            BigInteger b1 = new BigInteger(b);
            String sum = new BigInteger(a).add(b1).toString();
            System.out.println(sum);
        }
    }
}
