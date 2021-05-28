package K;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 汉明距离
 * 汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 */
public class T481 {
    public static int hammingDistance0(int x, int y) {
        char[] c0=getBinary(x).toCharArray();
        char[] c1=getBinary(y).toCharArray();
        Arrays.sort(c0);
        Arrays.sort(c1);
        int count=0,i=0,j=0;
        while (i<c0.length || j<c1.length){
            if (c0[i]==c1[i]){
                count++;
            }
            i++;
            j++;
        }
        return count;
    }

    private static String  getBinary(int n) {
        List<Integer> list=new ArrayList<>();
        while (n!=0){
            list.add(n%2);
            n=n/2;
        }
        while (list.size()<4){
           list.add(0,0);
        }
        StringBuilder sb=new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int x=1,y=4;
        System.out.println(hammingDistance(x, y));
    }
    public static int hammingDistance(int x, int y) {
        int count=0;
        if (x==y){
            return count;
        }
        while (x!=0 || y!=0){
            if (x%2!=y%2){
                count++;
            }
            x/=2;
            y/=2;
        }
        return count;
    }

    public static int hammingDistance1(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }
}
