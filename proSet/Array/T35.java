package LeetCode1.EveryDAY.Array.BinarySearch;

/**
 * 搜索插入位置
 * TIP：
 * 排序数组
 * 找到了，返回下标
 * 没找到，返回插入后的下标
 * 链接：https://leetcode-cn.com/problems/search-insert-position/
 */
public class T35 {
    //二分查找
    public static int searchInsert(int[] nums, int target) {
        int len=nums.length;
        //如果target比数组最后一个元素还要大，就尾插，返回数组长度即可
        if (len==0 || target>nums[len-1]){
            return len;
        }
        int l=0,r=len-1;

        while (l<r){
            int mid=(l+r)/2;
            //target<=中值
            if (target<=nums[mid]){
                r=mid;
            //target>中值
            }else {
                l=mid+1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int target=7;

        int res = searchInsert(nums, target);
        System.out.println(res);
    }
}
