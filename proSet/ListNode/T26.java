package LeetCode1.LIST.ListNode.T24;

import LeetCode1.LIST.ListNode.ListNode;

/**
 * 两两交换链表中的节点
 * 思路：递归，大问题化小问题，将n个几点两两交换问题化成三个节点中两节点交换问题
 * 再递归处理子问题
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/submissions/
 */
public class T24 {
    public static ListNode swapPairs(ListNode head) {
        if (head==null  || head.next==null){
            return head;
        }
        //节点关系：
        //1--2--3--4--5
        //1--2--(3--4--5)
        //将n个节点交换问题，简化成三个节点的问题，将后续节点看出一个(再递归处理整体里的每一个子节点)
        ListNode cur=head.next;
        head.next=swapPairs(cur.next);
        cur.next=head;
        head=cur;
        return head;
    }
}
