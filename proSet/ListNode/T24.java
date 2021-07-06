package LeetCode1.LIST.ListNode.offer;
import LeetCode1.LIST.ListNode.ListNode;

/**
 * 反转链表
 * 思路：从头遍历，从头开始改变节点关系，指针后移
 * 从后往前，前驱节点不好处理)
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class T24 {
    public static ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode newHead=new ListNode(-1);
        ListNode cur=head;
        ListNode prev=null;
        while (cur!=null){
            ListNode curNext=cur.next;
            if (curNext==null){
                newHead.next=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead.next;
    }
}
