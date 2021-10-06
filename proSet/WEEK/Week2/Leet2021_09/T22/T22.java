package Leet2021_09.T22;

import Leet2021_09.T06.ListNode;

/**
 * 链表中倒数第k个节点
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class T22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null){
            return null;
        }

        ListNode fast=head;
        ListNode slow=head;
        for (int i = 0; i < k; i++) {
            fast=fast.next;
        }

        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
