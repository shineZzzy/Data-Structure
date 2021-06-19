package Sort.T324_;
import java.util.Arrays;

/**
 * 摆动排序
 * 题意：将数组按照n[0]<n[1]>n[2]<n[3]>n[4]的形式，进行排序
 * 思路：仔细观察可以看到，实际上是将元素在奇偶位上降序排序、
 * 样例： 1,3,2,2,3,1---->2,3,1,3,1,2
 *       2,3,1,3,1,2
 *奇数位  2   1   1
 *偶数位    3   3   2
 * 因此，将数组整体降序排序后，按奇偶位插入即可。
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii/submissions/
 */
public class T324 {
    public static void wiggleSort(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        int[] res=new int[len];
        int i=1;
        for (int j = len-1; j>=0; j--) {
            if(i>len-1){
                i=0;
            }
            res[i]=nums[j];
            i+=2;
        }
        //没必要加这一句的，但是leetcode判题机很专一只认nums,不认我的res，只好将它搬过去了
        for (int j = 0; j < len; j++) {
            nums[j]=res[j];
        }
    }

    public static void main(String[] args) {
        int[] nums={1,5,1,1,6,4};
        wiggleSort(nums);
    }
}
