package K;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class T350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length==0 || nums2.length==0){
            return null;
        }

        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int la=nums1.length;
        int lb=nums2.length;
        int i=0,j=0;
        while (i< la && j<lb){
            if (nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else {
                j++;
            }
        }

        int[] n=new int[list.size()];
        int index=0;
        for (int k:list){
            n[index++]=k;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] n={1,2,2,1};
        int[] m={2,2};
        int[] res = intersect(n, m);
        System.out.println(Arrays.toString(res));
    }
}
