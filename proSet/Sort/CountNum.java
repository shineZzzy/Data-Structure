package LeetCode1.Sort;

import java.util.Arrays;

public class CountNum {
    public static int sumup(int[] inputArray) {
        int len=inputArray.length;
        if (len==0){
            return 0;
        }

        int a=inputArray[0];
        inputArray[0]=-0xFFFF;
        Arrays.sort(inputArray);
        int i=1,j=len-1;
        int sum=0;
        while (i<=j){
            int mid=(i+j)/2;
            if (inputArray[mid]>a){
                i=mid+1;
            }else {
                j=mid-1;
                sum+=inputArray[j];
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] nums={10,1,2,3,4,11};
        int sumup = sumup(nums);
        System.out.println(sumup);
    }
}
