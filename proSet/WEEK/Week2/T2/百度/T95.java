package Sloution.T1;

import java.util.Arrays;

public class T95 {
    public static void main(String[] args) {
//        String text1="abcde";
//        String text2="acb";


        String text1="psnw";
        String text2="vozsh";
        int res=longestCommonSubsequence(text1,text2);
        System.out.println(res);
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        if (n==0 && m==0){
            return 0;
        }


        int i=0,j=0;
        int cnt=0;
        char[] c1=text1.toCharArray();
        char[] c2=text2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        while (i<n && j<m){
            if(c1[i]!=c2[j]){
                i++;

            }else {
                cnt++;
                i++;
                j++;
            }
        }
        return cnt;
    }
}
