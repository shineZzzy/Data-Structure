package LeetCode.LeetCode.copyRandomList;

public class Solution {

    public ListNode copyRandomList(ListNode head) {
        if(head==null){
            return null;
        }
        //1.遍历老结点，复制新节点，构成新结构
        ListNode current=head;
        while (current!=null){
            //记录原cur的下一个指向
            ListNode curNext=current.next;
            //定义一个新节点，传入cur.val复制
            ListNode newNode=new ListNode(current.val);
//            current=current.next;
            //将新节点尾插到新链表中
            current.next=newNode;
            newNode.next=curNext;
            //cur后移
            current=curNext;
        }

        //random处理
        ListNode oldCurrent=head;
        while (oldCurrent!=null) {
            ListNode newCurrent =oldCurrent.next;
            //处理
            if(oldCurrent.random==null){
                newCurrent.random=null;
            }else {
                newCurrent.random=oldCurrent.random.next;
            }
            oldCurrent=oldCurrent.next.next;
        }
        //拆开
        oldCurrent=head;
        ListNode newHead=head.next;
        while (oldCurrent!=null){
            ListNode newCurrent =oldCurrent.next;

            oldCurrent.next=newCurrent.next;
            if(newCurrent.next!=null) {
                newCurrent.next = newCurrent.next.next;
            }
            oldCurrent=oldCurrent.next;
        }
        return newHead;
    }
}
