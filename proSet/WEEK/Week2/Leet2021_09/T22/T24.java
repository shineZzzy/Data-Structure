package Leet2021_09.T22;

import Leet2021_09.T06.ListNode;

/**
 * 反转链表
 * 思路：记录前驱节点，和后继节点，改变节点关系
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class T24 {
    public static ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode newHead=new ListNode(-1);
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            ListNode curNext=cur.next;
            if (curNext==null){
                newHead.next=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return newHead.next;
    }
}
