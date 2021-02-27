package Test.Day43;

import java.util.*;

/**
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false
 * 链接：https://leetcode-cn.com/problems/contains-duplicate/solution/hashsetqiu-jie-by-johnyang-2e-dtah/
 * 网友们真的太厉害了，我得加把劲了，刷题太少了！
 */

public class isRepetition {
    //方法1：暴力遍历
    //我是猪，双指针判断元素相同即为重复，不需要统计次数，不要想太多啊！
    public static boolean containsDuplicate(int[] nums) {

        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    //方法2：排序
    //妙，既是数字便可排序，排完看邻居
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }


    //方法3：Set
    //利用set去重的特性，是我蠢，能想到Map想不到set！
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);

        }
        return false;
    }
    //看到set解法时，还想到数组长度的角度，set去重后数组长度会发生变化
    //当然这种思路效率不会高，毕竟还得遍历添加到set，但至少是自己想到的一个思路嘛！
    public static boolean containsDuplicate3(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            set.add(nums[i]);
        }
        if (set.size()<nums.length){
            return true;
        }
        return false;
    }
    //方法4：Map
    public static boolean containsDuplicate4(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if (map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i],1);

        }
        return false;
    }

    public static void main(String[] args) {
        int[] n={1,2,3,4,2};
        boolean res=containsDuplicate3(n);
        System.out.println(res);
    }
}
