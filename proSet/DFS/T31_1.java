package Sort.T31;

/**
 * 下一个排列
 * 题意：就是该组数的全排列中比该序大一点点的序列，没有就返回最小的序列
 * 思路：找出数组中第一大的索引，就是最大值的前一个元素，再找到比第一大索引大一点点的元素，进行交换，之后翻转数组
 * 链接：https://leetcode-cn.com/problems/next-permutation/
 */
public class T31_1 {
    public static void nextPermutation(int[] nums) {
       int len=nums.length;
       int first=-1,second=0;
       //先找出第个比最大值小的元素，最大值之后就会降序，所以找小一点点的
        for (int i =len-2; i>=0; i--) {
            if (nums[i]<nums[i+1]){
                first=i;
                break;
            }
        }
        if(first==-1){
            reverse(nums,0,len-1);
            return;
        }
        //找出比第一个索引对于元素小一点点的值
        for (int i = len-1; i >=0; i--) {
            if (nums[i]>nums[first]){
                second=i;
                break;
            }
        }
        //交换两个值
        swap(nums,first,second);
        //将数组中降进行部分反转
        reverse(nums,first+1,len-1);

    }

    private static void reverse(int[] nums, int i, int j) {
        while (i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    public static void main(String[] args) {
//        int[] nums={1,2,7,4,3,1};
        int[] nums={1,2,1};
        nextPermutation(nums);
    }
}
