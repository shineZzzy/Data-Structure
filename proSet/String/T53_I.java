package LeetCode1.Sort.T53;

/**
 * 在排序数组中查找数字
 * TIP：排序数组
 */
public class T53_I {
    public static int search0(int[] nums, int target) {
        int len=nums.length;
        if (len==0){
            return 0;
        }
        int cnt=0;
        for (int i = 0; i < len; i++) {
            if (nums[i]==target){
                cnt++;
            }
        }
        return cnt;
    }

    public static int search(int[] nums, int target) {

        return helper(nums,target)-helper(nums,target-1);

    }

    private static int helper(int[] nums, int target) {
        int len=nums.length;
        int i=0,j=len-1;
        while (i<=j){
            int mid=(i+j)/2;
            if (nums[mid]>target){
                j=mid-1;
            }else {
                i=mid+1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target=8;
        int res = search(nums, target);
        System.out.println(res);
    }
}
