package LeetCode.奇安信.T2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        int[] nums={1,2,2,4};
        int[] nums={1,};
        int[] res = findNums(nums);
        System.out.println(Arrays.toString(res));
    }
    public static int[] findNums (int[] nums) {
        int len=nums.length;
        if (len==0){
            return new int[]{};
        }
        Arrays.sort(nums);

        List<Integer> list=new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (nums[i]==nums[i-1]){
                list.add(nums[i]);
                list.add(i+1);
            }
        }
        int[] res=new int[list.size()];
        int index=0;
        for (Integer i : list) {
            res[index++]=i;
        }

        return res;

    }
}
