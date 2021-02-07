package Test.Day35;

import java.util.Scanner;

public class getMax2 {
    public static int calculateMax(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String[] s=sc.nextLine().split(",");
            int[] n=new int[s.length];
            for (int i = 0; i <s.length; i++) {
                n[i]=Integer.parseInt(s[i]);
            }
            int res=calculateMax(n);
            System.out.println(res);
        }
    }
}
