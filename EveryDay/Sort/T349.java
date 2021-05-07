package LeetCode.Sort;

import java.util.*;

/**
 * 两个数组的交集
 * 描述：给定两个数组，编写一个函数来计算它们的交集
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class T349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length==0 || nums2.length==0){
            return null;
        }
        List<Integer> s1=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for (int value : nums1) {
            set.add(value);
        }
        for (int value : nums2) {
            if (set.contains(value) && !s1.contains(value)) {
                s1.add(value);
            }
        }
        int[] n=new int[s1.size()];
        for (int i = 0; i < s1.size(); i++) {
            n[i]=s1.get(i);
        }
        return n;
    }

    public static void main(String[] args) {
        int[] m={1,2,2,1};
        int[] n={2,2};

        int[] res = intersection(m, n);
        System.out.println(Arrays.toString(res));

    }
}
