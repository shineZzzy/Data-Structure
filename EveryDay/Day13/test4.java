package Day13;

import java.math.BigInteger;
import java.util.Scanner;

public class test4 {
    public static String Add(String a,String b){

        BigInteger b1 = new BigInteger(b);
        String sum = new BigInteger(a).add(b1).toString();
        return sum;
    }

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        String a=s.nextLine();
        String b=s.nextLine();
        System.out.println(Add(a, b));
    }
}
