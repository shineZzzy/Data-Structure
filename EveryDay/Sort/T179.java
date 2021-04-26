package LeetCode.Top100.Array;

import java.util.Arrays;

public class T179 {
    public static String largestNumber0(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = "" + nums[i];
        }
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a ;
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0') {
            k++;
        }
        return sb.substring(k);

    }
    public static String largestNumber(int[] nums) {
        int n=nums.length;
        String[] s=new String[n];
        for (int i = 0; i < n; i++) {
            s[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(s,(a,b)->{
            return (b+a).compareTo(a+b);
        });
//        Arrays.sort(s, Collections.reverseOrder());

        if (s[0].equals("0")){
            return "0";
        }

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        int[] n={3,30,34,5,9};
//        int[] n={10,2};
        System.out.println(largestNumber(n));

    }
}
