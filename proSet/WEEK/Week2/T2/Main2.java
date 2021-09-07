package LeetCode.奇安信.T2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
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

        List<Integer> list=new ArrayList<>();

        int[] res=new int[list.size()];
        int index=0;
        for (Integer i : list) {
            res[index++]=i;
        }

        return res;

    }
}
