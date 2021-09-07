package LeetCode.奇安信.T2;

import java.util.*;

/**
 * 找卡片
 * 返回重复数字和缺失的数字
 * n张卡片，在1~n范围内
 */
public class Main1 {
    public static void main(String[] args) {
//        int[] nums={1,2,2,4};
        int[] nums={1,2,2,4,5,5,7};
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
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<len;i++){
            if (map.containsKey(nums[i])){
                list.add(nums[i]);
                list.add(i+1);
            }else {
                map.put(nums[i],i+1);
            }
        }
        int[] res=new int[list.size()];
        int index=0;
        for (Integer k : list) {
            res[index++]=k;
        }

        return res;

    }
}
