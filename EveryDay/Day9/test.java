package Day9;

import java.math.BigInteger;
import java.util.Scanner;

public class test {
    public static BigInteger resN(BigInteger a)
    {
        if(a.compareTo(new BigInteger("1")) <= 0)
            return new BigInteger("1");
        else
            return a.multiply(resN(a.subtract(new BigInteger("1"))));
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            BigInteger n=scan.nextBigInteger();
            BigInteger res=resN(n);
            System.out.println(res);
        }
    }
}
