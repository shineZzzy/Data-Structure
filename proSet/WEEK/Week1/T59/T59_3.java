package LeetCode.剑指offer.Week1.T59;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class T59_3 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n==0 || k==0){
            return new int[]{};
        }
        Deque<Integer> deque = new LinkedList<Integer>();

        //窗口初始化(就是数据元素在窗口内)

        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        System.out.println(deque);

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,3,-1,3,5,3,6,7};
        int k=3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
