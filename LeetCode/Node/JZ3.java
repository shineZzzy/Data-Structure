package offer67.Node;

import java.util.ArrayList;

public class JZ3 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        if (listNode==null){
            return list;
        }
        ListNode dummy;
        dummy=listNode;
        ListNode curr=listNode;
        ListNode pre=null;

        while (curr!=null){
            ListNode currNext=curr.next;
            if (currNext==null){
                dummy=curr;
            }
            curr.next=pre;
            pre=curr;
            curr=currNext;
        }
        while (dummy!=null){
            list.add(dummy.val);
            dummy=dummy.next;
        }

        return list;
    }
}
