package Day15;

import java.math.BigInteger;

//不允许使用+号
public class sumN {
    public static int addAB(int A, int B) {
        BigInteger a=new BigInteger(String.valueOf(A));
        BigInteger b=new BigInteger(String.valueOf(B));

        BigInteger sum=new BigInteger(String.valueOf(A)).add(b);
        int res=Integer.parseInt(String.valueOf(sum));
        return res;
    }
}
