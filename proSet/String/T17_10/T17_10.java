package LeetCode1.EveryDAY.String.T17_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 主要元素
 * TIP：1.不是单纯的众数
 * 2.是出现次数超过总数一半的数
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class T17_10 {
    //暴力执法
    public static int majorityElement0(int[] nums) {
        int len=nums.length;
        if (len==0){
            return -1;
        }
        int max=0,temp=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < len; i++) {
            int cnt=1;
            if (map.containsKey(nums[i])){
                cnt=map.get(nums[i]);
                cnt++;
            }
            map.put(nums[i],cnt);
            if (cnt>max){
                max=cnt;
                temp=nums[i];
            }
        }
        if (max>((len-1)/2)){
            return temp;
        }
        System.out.println(map);
        return -1;
    }
    //map优化
    public static int majorityElement(int[] nums) {
        int len=nums.length;
        if (len==0){
            return -1;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if (map.get(nums[i])>(len/2)){
                return nums[i];
            }
        }
        return -1;
    }
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret =majorityElement(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
    //桶排序
    public static int majorityElement2(int[] nums) {
        int len=nums.length;
        if (len==0){
            return -1;
        }
        Arrays.sort(nums);
        int cnt=0;
        int max=0,temp=0;
        for (int i = 1; i < len; i++) {
            if (nums[i]==nums[i-1]){
                cnt++;
            }else {
                cnt--;
            }

        }
        return -1;
    }
}
