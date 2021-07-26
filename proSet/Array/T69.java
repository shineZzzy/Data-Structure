package LeetCode1.EveryDAY.Array.BinarySearch;

/**
 * X的平方根
 * TIP：返回值向上取整
 */
public class T69 {
    //API
    public static int mySqrt1(int x) {
        return (int) Math.sqrt(x);
    }
    //二分
    public static int mySqrt(int x){
        int l=0,r=x;
        while (l<r){
            int mid=(l+r+1)/2;
            //x<mid^2 && x>=mid^2
            if (mid<=x/mid){
                l=mid;
            }else {
                r=mid-1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int x=8;
        int res = mySqrt(x);
        System.out.println(res);
    }
}
