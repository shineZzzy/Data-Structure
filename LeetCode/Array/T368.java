package LeetCode.Top100.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T368 {
    /*

     */
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list=new ArrayList<>();
        if (nums.length == 0){
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            int n=nums[i];
//            list.add(nums[i]);
            if (!list.contains(nums[i])){
                list.add(nums[i]);
            }
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]%n==0){
//                    if (!list.contains(nums[i])){
//                        list.add(nums[i]);
//                    }
                    if (!list.contains(nums[j])){
                        list.add(nums[j]);
                    }

                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(j)%list.get(i)!=0){
                    list.remove(list.get(i));
                }
            }
        }
        return list;
    }

    public static List<Integer> isList(int[] nums){
        List<Integer> list=new ArrayList<>();
        if (nums.length==0){
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j>0; j--) {
                if(nums[j]%nums[i]==0){
                    if (!list.contains(nums[j])){
                        list.add(nums[j]);
                    }

                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] n={8};
        List<Integer> res = isList(n);
        System.out.println(res);

    }
}
