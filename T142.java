package LeetCode1.LIST.ListNode.WEEK2;

import LeetCode1.LIST.ListNode.ListNode;

/**
 * 环形链表II
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class T142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;

        while (fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast){
                return slow;
            }
        }

        if (fast==null || fast.next==null){
            return null;
        }

        slow=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
