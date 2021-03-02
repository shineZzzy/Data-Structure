package Test.Day45;

/**
 * 寻找中心索引
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * 数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 **/

public class midIndex {
    public static int pivotIndex(int[] nums) {
        //每加一个数，都计算它后面的数之和
        for (int i = 0; i <nums.length ; i++) {
            int left=0;
            int right =0;
            for (int j = 0; j <i; j++) {
                left+=nums[j];
            }
            for (int j = i+1; j <nums.length ; j++) {
                right +=nums[j];
            }
            if (left==right){
                return i;
            }
        }
        return -1;
    }
    //前项和,先计算总和，然后再遍历，s2加一个,s1就减一个，直至相等
    public static int pivotIndex1(int[] nums) {
        int sum1=0;
        int sum2=0;
        for (int i = 0; i <nums.length ; i++) {
            sum1 += nums[i];
        }
        for (int i = 0; i <nums.length ; i++) {
            sum2 += nums[i];
            if (sum1==sum2){
                return i;
            }
            sum1=sum1-nums[i];
        }
        return -1;
    }
    //后项和
    public static int pivotIndex2(int[] nums) {
        int sum =0;
        int total=0;
        for (int n:nums) {
            total += n;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (2* sum +nums[i]==total){
                return i;
            }
           sum+=nums[i];
        }
        return -1;
    }
    public static int pivotIndex3(int[] nums) {

        //双指针从两端扫描，(错误代码)
        //问题：不能解决，测试用例[2,1,-1]  结果：0
        //第一个数字左边没有数字了，索引就是0，所以中心索引就是第一个数
        int left =0;
        int right =0;
        int i=0;
        int j=nums.length-1;
        while (i<j){
            left +=nums[i];
            right +=nums[j];
            if (left == right){
                return j-1;
            }
            if(right > left){
                i++;
                left +=nums[i];
            }else {
                j--;
                right +=nums[j];
            }
            i++;
            j--;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] n1={1, 7, 3, 6, 5, 6};
        int[] n2={1,2,3};
        int[] n={2,1,-1};
        int res=pivotIndex(n);
        System.out.println(res);
    }
}
