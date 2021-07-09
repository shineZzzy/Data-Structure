package LeetCode1.EveryDAY.String.T17_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 摩尔投票
 * 先遍历一遍数组，找出可能关键数(根据出现的次数相互抵消，最后的次数！=0，即可能为目标数)，再遍历一次统计众数出现的次数
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci/solution/gong-shui-san-xie-yi-ti-shuang-jie-ha-xi-zkht/
 * eg: 1,4,1,2,1,5,1,1
 *     + - + - + - + +
 * cnt:1 0 1 0 1 0 1 2    target=1
 */
public class T17_10_1 {
    public static int majorityElement(int[] nums) {
        int len=nums.length;
        if (len==0){
            return -1;
        }
        int target=-1;
        int cnt=0;
        for (int i = 0; i < len; i++) {
            if (cnt==0){
                target=nums[i];
            }
            if (nums[i]==target){
                cnt++;
            }else {
                cnt--;
            }
        }
        cnt=0;
        for (int i = 0; i < len; i++) {
            if (nums[i]==target){
                cnt++;
            }
        }
        if (cnt>(len/2)){
            return target;
        }else {
            return -1;
        }
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
}
