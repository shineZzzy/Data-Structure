package Test.Day40;

/**
 * 回文串
 * 方法二：数学思想
 */
public class Palindrome2 {
    public static boolean isPalindrome(int x) {
        //情况1：所有负数不是回文数
        //情况2：如果该数最后一位为0，如果是回文数那首位数也应该为0，但这不符合整数！
        if(x<0 || (x%10==0 && x!=0)){
            return false;
        }
        int res=0;
        //注意这个条件，判断到中间位即可
        while (x>res){
            //回忆之前反转整数那道题！
            res =res*10+x%10;
            x /=10;
        }
        //如果是偶数位，最终res==x，true
        //如果为奇数位，可以去掉中间位，判断是否相等
        //当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        return x==res || x==res/10;
    }

    public static void main(String[] args) {
        int x=12321;
        boolean res=isPalindrome(x);
        System.out.println(res);
    }
}
