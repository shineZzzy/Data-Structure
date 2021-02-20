package Test.Day40;

/**
 *给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字
 *
 */


class ListNode{
   int val;
   ListNode next;
   ListNode() { }
   ListNode(int val){
       this.val=val;
   }
    ListNode(int val, ListNode next) {
       this.val = val; this.next = next;
   }
}
public class addTowNum2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode cur=head;
        ListNode p=l1;
        ListNode q=l2;

        int carry=0;
        while (p!=null || q!=null){
            int n1=(p!=null) ? p.val:0;
            int n2=(q!=null) ? q.val:0;
            int sum=carry+n1+n2;
            carry=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            if(p!=null){
                p=p.next;
            }
            if(q!=null){
                q=q.next;
            }
        }
        if(carry>0){
            cur.next=new ListNode(carry);
        }
        return head.next;

    }

    //public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //        ListNode head = null, tail = null;
    //        int carry = 0;
    //        while (l1 != null || l2 != null) {
    //            int n1 = l1 != null ? l1.val : 0;
    //            int n2 = l2 != null ? l2.val : 0;
    //            int sum = n1 + n2 + carry;
    //            if (head == null) {
    //                head = tail = new ListNode(sum % 10);
    //            } else {
    //                tail.next = new ListNode(sum % 10);
    //                tail = tail.next;
    //            }
    //            carry = sum / 10;
    //            if (l1 != null) {
    //                l1 = l1.next;
    //            }
    //            if (l2 != null) {
    //                l2 = l2.next;
    //            }
    //        }
    //        if (carry > 0) {
    //            tail.next = new ListNode(carry);
    //        }
    //        return head;
    //    }
    //

}


