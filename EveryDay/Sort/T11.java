package offer.week1;

/**
 * 旋转数组的最小数字
 * 题意：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 样例：数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * 思想：二分查找
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 *
 */
public class T11 {
    //永远的"暴力"！（都是递增的就直接遍历，找到第1个小的数）
    public static int minArray0(int[] numbers) {
        int len=numbers.length;
        for (int i = 0; i < len; i++) {
            if (i+1<len && numbers[i]>numbers[i+1]){
                return numbers[i+1];
            }
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        int[] num={3,4,5,1,2};
        int res = minArray(num);
        System.out.println(res);
    }

    //二分思想：牛！
    //缩小查找范围！(leetcode超时了)
    public static int minArray1(int[] numbers) {
        int len=numbers.length-1;
        if(len<0){
            return -1;
        }
        //如果前面存在重复的值，就跳过
        while (len>0 && numbers[len]==numbers[0]){
            len--;
        }
        //如果最后的值和最前面的相等，则最小的就是第一个
        if (numbers[len]>=numbers[0]){
            return numbers[0];
        }
        //以上两种情况都不符合，就二分查找
        int left=0,right=len;
        while (left<right){
            int mid=(left+right)/2;
            if (numbers[mid]<numbers[0]){
                right=mid;
            }else {
                left=mid+left;
            }
        }
        return numbers[right];
    }

    //二分
    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high --;
            }
        }
        return numbers[low];
    }
}
