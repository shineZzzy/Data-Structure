package K.T1122;

import java.util.Arrays;

/**
 * T1122-数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 思想：插排
 * 先遍历arr1，对元素x出现次数进行统计，再在遍历arr2时，遇到x时按统计的次数全部插入，arr2中不存在的元素则尾插在数组后面
 */
public class T1122_5 {
    public static int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int max=0;
        for (int i = 0; i < arr1.length; i++) {
            max=Math.max(max,arr1[i]);
        }
        //统计x出现的次数
        int[] frequency =new int[max+1];
        for (int i = 0; i < arr1.length; i++) {
            frequency[arr1[i]]++;
        }
        int[] res=new int[arr1.length];
        int index=0;
        //遍历arr2
        for (int i = 0; i < arr2.length; i++) {
            //按arr1中出现的次数，全部插入其中
            for (int j = 0; j < frequency[arr2[i]]; j++) {
                res[index++]=arr2[i];
            }
            //插入后将x次数置为0，易于区分
            frequency[arr2[i]]=0;
        }
        //将arr2中不存在的元素尾插在数组后面
        for (int i = 0; i <=max; i++) {
            for (int j = 0; j < frequency[i]; j++) {
                res[index++]=i;
            }
        }

        return res;
        
    }
    public static void main(String[] args) {
        int[] a={2,3,1,3,2,4,6,7,9,2,19};
        int[] b={2,1,4,3,9,6};
        int[] res = relativeSortArray1(a, b);
        System.out.println(Arrays.toString(res));
    }
}
