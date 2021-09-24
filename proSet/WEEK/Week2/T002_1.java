package Sloution.T0923;

public class T002_1 {
    public static String longestCommonPrefix (String[] strs) {
        int n=strs.length;
        if (n==0){
            return null;
        }
        StringBuilder res=new StringBuilder();
        char[] ch=strs[0].toCharArray();
        int len=ch.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < n; j++) {
                if (i==strs[j].length() ||strs[j].charAt(i)!=ch[i]){
                    return strs[0].substring(0,i);
                }
            }
        }
        return null;
    }
}
