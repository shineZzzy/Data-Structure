package Java;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 给定一个数组，
 * 将数组中的元素向右移动 k个位置
 * nums = [1,2,3,4,5,6,7], k = 3
 */
public class add {
    public static void rotate(int[] num, int k) {
        int n = num.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = num[i];
        }

        System.arraycopy(newArr, 0, num, 0, n);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(",");
        int k=sc.nextInt();
        int[] n=new int[s.length];

        for (int i=0;i<s.length;i++){
            n[i]=Integer.parseInt(s[i]);
        }
        System.out.println(Arrays.toString(n));

        rotate(n,k);
        System.out.println(Arrays.toString(n));

    }
}
