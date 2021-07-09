package offer.week1;

/**
 * 不修改数组找出重复的数
 * 题意：
 * 给定一个长度为 n+1 的数组nums，数组中所有的数均在 1∼n 的范围内，其中 n≥1。
 * 请找出数组中任意一个重复的数，但不能修改输入的数组
 * 链接：https://www.acwing.com/problem/content/15/
 */
public class T14 {
    /**
     * 1.一共有 n+1 个数，每个数的取值范围是1到n，所以至少会有一个数出现两次
     * 2.在[left,mid]的取值范围中，共有x+1个数，而该区间长度为x，说明在次区间在有数重复。
     * 抽屉原理：2和抽屉放3个苹果，则必然有一个抽屉里放了两个苹果！！！
     * 题解：https://www.acwing.com/solution/content/693/
     */
    public static int duplicateInArray(int[] nums) {
        int left=1,right=nums.length-1;
        while (left<right){
            int mid=(right+left)/2;
            int s=0;
            for (int i = 0; i < nums.length; i++) {
                //取值范围[left,mid]
                if (nums[i]>=left && nums[i]<=mid){
                    s++;
                }
            }
            //当数的个数>区间长度，说明该区间有数重复，继续缩小
            if (s>(mid-left+1)){
                right=mid;
                //当数的个数<区间长度,此区间没有重复，去高区间找
            }else {
                left=mid+1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] num={2,3,5,4,3,2,6,7};
        int res = duplicateInArray(num);
        System.out.println(res);
    }
}
