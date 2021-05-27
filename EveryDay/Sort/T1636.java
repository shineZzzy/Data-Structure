package K;

import java.util.*;

/**
 * 按照频率将数组升序排序
 * 要求：如果元素频率相对，则按数值大小降序排列
 * 思路：map+sort
 * 链接：https://leetcode-cn.com/problems/sort-array-by-increasing-frequency/
 */
public class T1636 {
    //看了题解，自己写的确实过于繁琐
    public static int[] frequencySort(int[] nums) {
        //这里统计次数，可以再简洁处理
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count=1;
            if (map.containsKey(nums[i])){
                count = map.get(nums[i]);
                count++;
            }
            map.put(nums[i],count);
        }
        int[][] res=new int[map.size()][2];
        int i=0;
        for (Integer key:map.keySet()){
            if (i<map.size()) {
                res[i][0] = key;
                res[i][1] = map.get(key);
                i++;
            }else {
                break;
            }
        }
        //插排没处理好频率相同的元素降序排的要求
//        insert(res);
        //如果频率相同，降序排
        Arrays.sort(res,new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[1]==o2[1]){
                    return o2[0]-o1[0];
                }
                return o1[1]-o2[1];
            }
        });
        int[] num=new int[nums.length];
        int count=0,index=0;
        for (int j = 0; j < res.length; j++) {
            num[index]=res[j][0];
            count=res[j][1];
            for (int k = 0; k < count; k++) {
                num[index++]=res[j][0];
            }
        }
        return num;
    }

    private static void insert(int[][] res) {
        for (int i = 0; i < res.length-1; i++) {
            int[] temp=res[i+1];
            int key=temp[1];
            int j=0;
            for (j=i;j>=0;j--){
                if (res[j][1]>key){
                    res[j+1]=res[j];
                }else {
                    break;
                }
            }
            res[j+1]=temp;
        }
    }

    public static void main(String[] args) {
        int[] nums1={1,1,2,2,2,3};
        int[] nums2={2,3,1,3,2};
        int[] nums={-1,1,-6,4,5,-6,1,4,1};
        System.out.println(Arrays.toString(frequencySort1(nums)));
    }
    //网友的题解
    public static int[] frequencySort1(int[] nums) {
        int[] count = new int[201];
        ArrayList<Integer> n1 = new ArrayList<Integer>();
        for(int i: nums){
            count[i+100]++;
            n1.add(i);
        }
        System.out.println(n1);
        System.out.println(Arrays.toString(count));
        Collections.sort(n1, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                if(count[o1+100]==count[o2+100]){
                    return o2-o1;
                }else{
                    return count[o1+100]-count[o2+100];
                }
            }
        });
        for(int i=0; i<nums.length; ++i){
            nums[i]=n1.get(i);
        }
        return nums;
    }
}
