package Test.Day45;

import java.util.Arrays;

/**
 * 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 理解：一个整数存放到数组中，要求是给这整数+1,以数组形式打印
 * 三种情况：1.非9结尾 、2.9结尾 、3.全为9
 */
public class sumOne {

    public static int[] plusOne1(int[] digits) {
        //非9结尾
        for (int i = digits.length-1 ; i >=0; i--) {
            if (digits[i]==9){
                digits[i]=0;
            }else {
                digits[i]++;
                return digits;
            }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;

    }

    public static int[] plusOne0(int[] digits) {

        int sum=0;
        for (int i = 0; i <digits.length ; i++) {
            sum=sum*10+digits[i];
        }
        sum+=1;
        StringBuilder sb=new StringBuilder();
        while (sum!=0){
            sb.append(sum%10);
            sum=sum/10;
        }
        int[] n=new int[sb.length()];
        int j=sb.length()-1;
        for (int i = 0; i <sb.length(); i++) {
            n[i]=Integer.parseInt(String.valueOf(sb.charAt(j)));
            j--;
        }
        return n;
    }
    //要考虑进位问题
    //从后向前，若有进位则逐个向上加
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >0 ; i--) {
            digits[i]++;
            digits[i]=digits[i]%10;
            if (digits[i]!=0){
                return digits;
            }
        }
        //处理9999进位问题，999+1=1000  9+1=10
        digits=new int[digits.length+1];
        //将首位置为1，最后一位自动补全为1
        digits[0]=1;
        return digits;
    }

    public static void main(String[] args) {
        int[] n={0};
        int[] res=plusOne1(n);
        System.out.println(Arrays.toString(res));
    }
}
