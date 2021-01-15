package Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给一个数组 nums 和一个值 val，需要 原地 移除所有数值等于 val 的元素，
 * 并返回移除后数组的新长度
 * list:用额外空间了
 */
public class remove1 {
    public static int removeElement(int[] nums, int val) {
        List<Integer>list=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        for (int i=0;i<list.size();i++){
            if (list.get(i)==val){
                list.removeAll(Collections.singleton(list.get(i)));
            }
        }
        System.out.println(list);
        return list.size();
    }

    public static void main(String[] args) {
        int[] n={3,2,2,3};
        int k=3;
        System.out.println(removeElement(n, k));


    }
}
