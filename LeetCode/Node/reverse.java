package offer67.Node;


import java.util.Stack;
//反转链表：该滚瓜烂熟了兄弟！
//反转，前进后出---考虑栈

public class reverse {
    //栈的思想
    public static ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        Stack<ListNode> stack=new Stack<>();
        //因为考虑到是前后颠倒的处理，可以使用栈
        ListNode current=head;
        //所有节点全部入栈
        while (current!=null){
            stack.push(current);
            current=current.next;
        }
        //节点出栈，并重写拼接，返回头节点
        ListNode newHead;
        ListNode cur=stack.pop();
        newHead=cur;
        while (!stack.isEmpty()){
            ListNode pop=stack.pop();
            //拼接
            cur.next=pop;
            cur=cur.next;
        }
        cur.next=null;
        return newHead;
    }
    //链表前后关系
    public static ListNode ReverseList1(ListNode head) {
        if(head==null){
            return null;
        }

//        ListNode newHead=null;
        //傀儡节点
        ListNode newHead=new ListNode(-1);
        newHead.next=head;

        ListNode pre=null;
        ListNode curr=head;


        while (curr!=null){
            ListNode curNext=curr.next;
            //遍历到最后一个节点了，他就作为新链表的头返回
            if (curNext==null){
                newHead.next=curr;
            }
            //交换前后关系
            curr.next=pre;
            pre=curr;
            //因为节点前后关系发生变化，想要先记录原来节点的位置，再改变(相当于引入temp做交换)
            curr=curNext;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode root=new ListNode(5);
        ListNode r1=new ListNode(4);
        ListNode r2=new ListNode(3);
        ListNode r3=new ListNode(2);
        ListNode r4=new ListNode(1);

        root.next=r1;
        r1.next=r2;
        r2.next=r3;
        r3.next=r4;
        r4.next=null;

        ListNode listNode = ReverseList(root);
        System.out.println(listNode);
    }
}
