package EveryDay.offer.TreeNode.case4;

public class mergeSort {
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here

        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head;
        if(l1.val<l2.val){
            head=l1;
        }else{
            head=l2;
        }

        ListNode cur=head;

        while(l1!=null && l2!=null){
            if(l1.val<= l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }

        if(l1==null){
            cur.next=l2;
        }else{
            cur.next=l1;
        }
        return cur;
    }
}
