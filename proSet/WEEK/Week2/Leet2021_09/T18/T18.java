package Leet2021_09.T18;

/**
 * 删除链表的节点
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class T18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head==null){
            return null;
        }
        if (head.val==val){
            head.next=head;
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
