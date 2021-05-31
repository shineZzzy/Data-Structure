package K.Middle;

import java.util.Arrays;

/**
 * H指数
 * 题意：找c[i]>i的所有个数
 * 链接：https://leetcode-cn.com/problems/h-index/
 */
public class T274 {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i=0;
        //指数！！！
        //逆序找，只要c[i]>i，即可
        while (i<citations.length && citations[citations.length-i-1]>=i){
            System.out.println(citations[citations.length - i - 1]);
            i++;
        }
        return i;
    }


    public static void main(String[] args) {
        int[] content1={3,0,6,1,5};
        int[] content2={1,1,3};
        int[] content={0,1};
        int res = hIndex(content1);
        System.out.println(res);
    }
}
