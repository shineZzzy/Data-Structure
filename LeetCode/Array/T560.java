package LeetCode.Top100.Array;

import java.util.HashMap;
import java.util.Map;

public class T560 {
    public static int subarraySum1(int[] nums, int k) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],count);
            }else {
                if (map.containsKey(k-nums[i])){
                    count++;
                }
            }
        }
        return count;
    }
    public static int subarraySum2(int[] nums, int k) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum=0;

                for (int n = i; n <=j; n++) {
                    sum+=nums[n];
                }
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }
    public static int subarraySum3(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        int sum=0;
        int count=0;
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] n={1,1,1};
        int k=2;
        int res = subarraySum4(n, k);
        System.out.println(res);
    }
    public static int subarraySum(int[] nums, int k) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }




    public static int subarraySum4(int[] nums, int k) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }
}
