package K;
import java.util.Arrays;

/**
 * 判断能否成为等差数列
 * 思路：先排序，再根据等差的条件进行判断
 * 链接：https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence/
 */
public class T1502 {
    public static boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length<2){
            return false;
        }
        Arrays.sort(arr);
        int j=arr.length-1;
        while (j-2>=0){
//            或者：arr[j-1]*2!=arr[j]+arr[j-2]
            if (arr[j]-arr[j-1]!=arr[j-1]-arr[j-2]){
                return false;
            }
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr={1,2,4};
        int[] arr1={1,3,5};
        boolean r0 = canMakeArithmeticProgression(arr);
        boolean r1 = canMakeArithmeticProgression(arr1);
        System.out.println(r0);
        System.out.println(r1);
    }
}
