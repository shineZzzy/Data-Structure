package EveryDay;

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}


public class removeAll {
    public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode cur = head;
            while (cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            return head;

    }
}
