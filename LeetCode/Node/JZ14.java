package offer67.Node;

/**
 * 链表中倒数第K个元素
 * 描述：输入一个链表，输出该链表中倒数第k个结点。
 */
public class JZ14 {
    public static ListNode FindKthToTail (ListNode pHead, int k) {
        if(k<0 || pHead==null){
            return null;
        }
        ListNode fast=pHead;
        ListNode slow=pHead;
        while((k-1)>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                return null;
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }



    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        ListNode n1=new ListNode(2);
        ListNode n2=new ListNode(3);
        ListNode n3=new ListNode(4);
        ListNode n4=new ListNode(5);
        root.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=null;
        ListNode listNode = FindKthToTail(root,4);
        System.out.println(listNode);

    }
}
