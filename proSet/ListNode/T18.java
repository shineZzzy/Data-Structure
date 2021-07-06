package LeetCode1.LIST.ListNode.offer;
import LeetCode1.LIST.ListNode.ListNode;

/**
 * 删除链表中的节点
 * 思路：节点的删除，记录前驱节点，改变节点关系
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */

public class T18 {
    //双指针
    public static ListNode deleteNode0(ListNode head, int val) {
        if (head==null){
            return null;
        }
        //记录前驱节点
        ListNode prev=null;
        ListNode cur=head;
        while (cur!=null){
            if (cur.val!=val){
                prev=cur;
                cur=cur.next;
            }else {
                //删除头节点
                if (cur==head){
                    head=head.next;
                    break;
                }else {
                    //非头节点
                    prev.next = cur.next;
                    cur = cur.next;
                }
            }
        }
        return head;
    }
    //单指针
    public static ListNode deleteNode(ListNode head, int val) {
        if(head==null){
            return null;
        }
        if (head.val==val){
            head=head.next;
        }
        ListNode cur=head;
        while (cur!=null && cur.next!=null){
            if (cur.next.val==val){
                cur.next=cur.next.next;
            }
            cur=cur.next;
        }
        return head;
    }
}
