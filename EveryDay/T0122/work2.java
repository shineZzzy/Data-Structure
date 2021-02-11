package Test.T0122;

public class work2 {
    public static boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        int i=0;
        int j=s.length();
        while (i<j){
            if(i<j){
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x=1221;
        System.out.println(isPalindrome(x));
    }
}
