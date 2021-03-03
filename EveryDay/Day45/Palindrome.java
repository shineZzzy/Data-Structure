package Test.Day45;

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 链接：https://leetcode-cn.com/problems/valid-palindrome/submissions/
 * 注意：与之前的回文判断稍有不同，本题需要对字母数字处理，即只处理字母数字部分
 */
public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()){
            return true;
        }
        int i=0;
        int j=s.length()-1;
        while (i<j){
            while (i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if (Character.isLowerCase(s.charAt(i))!=Character.isLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome1(String s) {
        StringBuilder sf =new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))){
                sf.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        int i=0;
        int j= sf.length()-1;
        while (i<j){
            if (Character.toLowerCase(sf.charAt(i)) != Character.toLowerCase(sf.charAt(j))){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}
