package Test.T0118;

import java.util.Arrays;

public class isStr {
    public static Boolean[] chkSubStr(String[] p, int n, String s) {
        Boolean[] b=new Boolean[n];
        for (int i=0;i<p.length;i++){
            if(!s.contains(p[i])){
                b[i]=false;
            }else {
                b[i]=true;
            }

        }
        return b;
    }
    public static void main(String[] args) {
        String[] s={"a","b","c","d"};
        int n=4;
        String  str="abc";
        System.out.println(Arrays.toString(chkSubStr(s, n, str)));
    }
}
