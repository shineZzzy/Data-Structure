package EveryDay.offer.TreeNode.case6;

public class isStr {
    public static int strStr(String haystack, String needle) {
        if (haystack.length()==0 && needle.length()==0){
            return 0;
        }
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            if (haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String a="aabaa";
        String b="baa";
        int res=strStr(a,b);
        System.out.println(res);
    }
}
