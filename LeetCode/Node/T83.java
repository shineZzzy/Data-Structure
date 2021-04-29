package offer67.Node;

/**
 * 删除链表中的重复元素
 * 描述：给出一个升序排序的链表，删除重复元素
 * 思路：因为链表已经有序，重复元素是相邻的，因此遇到重复的，就跳过(删除原理，考虑存在多个重复的情况)
 */
public class T83 {
    //leetcode:使每个元素只出现一次
    //删除所有重复的元素，使每个元素 只出现一次
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        ListNode curr=head;

        while (curr!=null){
            if (curr.next!=null && curr.val==curr.next.val){
                while (curr.next!=null && curr.val==curr.next.val){
                    curr=curr.next;
                }
            }else {
                temp.next=curr;
                temp=curr;
                curr=curr.next;
            }
        }
        return dummy.next;
    }
    //牛客：保留只出现一次的元素
    //删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
    public static ListNode deleteDuplicates1(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        ListNode curr=head;

        while (curr!=null){
            if (curr.next!=null && curr.val==curr.next.val){
                while (curr.next!=null && curr.val==curr.next.val){
                    curr=curr.next;
                }
                curr=curr.next;//区别在这！
            }else {
                temp.next=curr;
                temp=curr;
                curr=curr.next;
            }
        }
        temp.next=null;//避免死循环
        return dummy.next;
    }
}
