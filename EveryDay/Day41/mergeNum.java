package Test.Day41;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，
 * 使 nums1 成为一个有序数组
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
 */
public class mergeNum {
    //方法1：直接用库方法将数组2所有元素复制到数组1中，再统一排序
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
    //方法2：将所有元素统一搬到数组1中，再对数组1整体排序
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
    //方法3：创建额外数组
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        int cur;
        int[] extra=new int[m+n];
        while (i<m || j<n){
            if (i==m){
                cur=nums2[j++];
            }else if(j==n){
                cur=nums1[i++];
            }else {
                cur=nums1[i]<nums2[j]?nums1[i++]:nums2[j++];
            }
            extra[i+j-1]=cur;
        }
        //再将所有元素再搬回数组中
        for (int k = 0; k !=m+n ; ++k) {
            nums1[k]=extra[k];
        }
        System.out.println(Arrays.toString(nums1));
    }
    //方法4：将num1元素复制到额外数组中，再与num2元素相比较，将比较结果存放到nun1中
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int[] n2=new int[m];
        System.arraycopy(nums1,0,n2,0,m);

        //定义n2，num2的指针
        int i=0,j=0;
        //num1的指针
        int k=0;
        //比较额外和数组2中的值，按升序存入数组1中
        while (i<m && j<n){
            nums1[k++]=n2[i]<nums2[j]?n2[i++]:nums2[j++];
        }
        //如果额外数组有剩余
        if (i<m){
            System.arraycopy(n2,i,nums1,i+j,m+n-(i+j));
        }
        //如果数组2有剩余
        if(j<n){
            System.arraycopy(nums2,j,nums1,i+j,m+n-(i+j));
        }
        System.out.println(Arrays.toString(nums1));
    }
    //
    public static void merge4(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        int[] n1={1,2,3,0,0,0};
        int m=3;
        int[] n2={2,5,6};
        int n=3;
        merge3(n1,m,n2,n);
    }
}
