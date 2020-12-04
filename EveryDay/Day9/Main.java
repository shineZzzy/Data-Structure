package Day9;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static int countN(BigInteger n){
        int count=0;
        String s=String.valueOf(n);
        char[] c=new char[s.length()+1];
        for(int i=0;i<s.length();i++){
            c[i]=s.charAt(i);
        }
        System.out.println(c);
        for (int i=0;i<c.length;i++) {
            if (c[i]=='0'&&c[i+1]=='0') {

                count++;
            }
        }
        return count;
    }
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
//            System.out.println(res);
            System.out.println(countN(res));
        }
    }
}
