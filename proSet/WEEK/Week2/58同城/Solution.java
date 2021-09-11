package 笔试.同城.T1;

public class Solution {
    public static void main(String[] args) {
        int num=12345;
        int res = digitsRecursive(num);
        System.out.println(res);
    }
    public static int digitsRecursive (int num) {
        if(num<=1){
            return num;
        }
        int res=getNum(num);
        int t=0;
        if (res>=10){
            res=getNum(res);
        }
        return res;
    }

    private static int getNum(int num) {
        int res=0;
        while (num>0){
            res+=num%10;
            num/=10;
        }
        return res;
    }
}
