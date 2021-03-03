package Test.Day45;

/**
 * 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity/
 */
public class sortArray {
    public static int[] sortArrayByParity(int[] A) {
        //双指针
        int i=0;
        int j=A.length-1;
        int temp=0;
        while (i<j){
            if (A[i] %2==1 && A[j]%2==0 ){
                temp=A[i];
                A[i]=A[j];
                A[j]=temp;
            }else if(A[i]%2==0){
                i++;
            }else if(A[j]%2==1){
                j--;
            }
        }
        return A;
    }

    public static int[] sortArrayByParity2(int[] A) {
        //双指针
        int i=0;
        int j=A.length-1;
        int temp=0;
        while (i<j){
            while (A[i]%2==0 && i<j){
                ++i;
            }
            while (A[j]%2==1 && i<j){
                --j;
            }
            if (i<j){
                temp=A[i];
                A[i]=A[j];
                A[j]=temp;
                ++i;
                --j;
            }
        }
        return A;
    }
}
