package LeetCode.剑指offer.Week1.T59;
import java.util.*;

/**
 * 滑动窗口的最大值
 * 思路：滑动窗口、单调队列
 * 通过单调队列，控制入队出队、窗口滑动、维护队列元素的递减
 * 满足窗口值时，队首即为当前区间内的最大值
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */

public class T59_1 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();

        for (int i = 0; i <nums.length; i++) {

            // 删除队首元素，保证每次连续滑动3个值
            // j-i >= k 时，超出窗口值，队首出队
            while (!deque.isEmpty() && deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            //如果队尾元素<当前元素，删掉队尾元素，
            //直到对内所有元素都大于等于当前元素，维护队列递减的特性
            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            //达到窗口值时，队首元素即为当前区间内最值
            if (i>=k-1){
                res.add(nums[deque.peekFirst()]);
            }
        }
        int[] ret=new int[res.size()];
        int i=0;
        for (Integer j : res) {
            ret[i++]=j;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums={1,3,-1,3,5,3,6,7};
        int k=3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
