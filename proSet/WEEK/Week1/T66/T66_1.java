package LeetCode.剑指offer.Week1.T66;

import java.util.Arrays;

/**
 * 构建乘积数组
 * 思路：曲线救国
 *      res[i]=i左边的所有元素的乘积 * i右边所有元素的乘积
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */
public class T66_1 {
    public static int[] constructArr(int[] a) {
        int len=a.length;
        int[] res=new int[len];
        //计算res[i]=前i-1个元素的乘积
        for (int i = 0,temp=1; i < len; i++) {
            res[i]=temp;
            temp*=a[i];
        }
        //计算res[i]=第i+1~n的所有元素的乘积
        for (int i=len-1,temp=1;i>=0;i--){
            res[i]*=temp;
            temp*=a[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int[] res = constructArr(nums);
        System.out.println(Arrays.toString(res));
    }
}
