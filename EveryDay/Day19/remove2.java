package Java;

import java.util.Arrays;

/**
 * 思路：
 * 将当前元素与最后一个元素进行交换，
 * 并释放最后一个元素。这实际上使数组的大小减少了 1。
 */
public class remove2 {
    public static int removeElement(int[] nums, int val) {
        int i=0;
        int n=nums.length;
        while (i<n){
            if (nums[i]==val){
                nums[i]=nums[n-1];
                n--;
            }else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return n;
    }

    public static void main(String[] args) {
        int[] n={3,2,2,3};
        int k=3;
        removeElement(n,k);
//        System.out.println(removeElement(n, k));
    }

}
