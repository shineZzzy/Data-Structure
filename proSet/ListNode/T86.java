package LeetCode1.LIST.ListNode.T86;

import LeetCode1.LIST.ListNode.ListNode;

public class T86 {
    public static ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }
        ListNode left=head;
        ListNode key=head;
        ListNode cur=head;
        ListNode right=null;
        while (cur!=null){
            if (cur.val!=x){
                cur=cur.next;
            }else {
                ListNode curNext=cur.next;
                key=cur;
                if (cur.next!=null){
                    cur.next=null;
                    right=curNext;
                }else {
                    right=left.next;
                }

                while (left!=null && right!=null){
                    ListNode leftNext=left.next;
                    if (right.val>left.val && right.val<left.next.val){
                        left.next=right;
                        right.next=leftNext;
                    }else {
                        left=left.next;
                        right=right.next;
                    }
                }

            }
        }
        return head;
    }
}
