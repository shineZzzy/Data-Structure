package Day13;

import java.math.BigInteger;
import java.util.Scanner;

public class longSum2 {
    public static String Add(String a,String b){

        BigInteger a1=new BigInteger(a);
        BigInteger b1=new BigInteger(b);
        BigInteger c=a1.add(b1);
        String sum=String.valueOf(c);

        return sum;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String a=s.nextLine();
        String b=s.nextLine();
        System.out.println(Add(a, b));
    }
}
