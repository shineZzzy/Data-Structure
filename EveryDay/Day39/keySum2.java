package Test.Day39;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法二：Hashmap
 */
public class keySum2 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                //如果map中有和当前值的和=target，直接返回二者下标
                return new int[]{map.get(target-nums[i]),i};
            }
            //没有，就将当前值存入map中，避免值重复
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] n={2,7,11,15};
        int key=9;
        int[] res=twoSum(n,key);
        System.out.println(res);
    }
}
