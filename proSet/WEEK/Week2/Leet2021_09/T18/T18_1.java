package Leet2021_09.T18;
/**
 * 删除链表的节点
 * 思想：双指针，一个记录当前节点，一个记录前驱节点
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class T18_1 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head==null){
            return null;
        }

        if (head.val==val){
            head=head.next;
        }

        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            if (cur.val==val){
                pre.next=cur.next;
            }
            pre=cur;
            cur=cur.next;
        }
        return head;
    }
}
