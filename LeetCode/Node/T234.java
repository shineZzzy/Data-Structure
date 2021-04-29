package offer67.Node;

import java.util.ArrayList;
import java.util.List;

public class T234 {
    //借助数组实现回文判断
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode curr=head;
        while (curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }

        int i=0;
        int j=list.size()-1;
        while (i<j){
            if(!list.get(i).equals(list.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //翻转后半段
    
    public static ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }

//        ListNode newHead=null;
        //傀儡节点
        ListNode newHead;
        newHead=head;

        ListNode pre=null;
        ListNode curr=head;


        while (curr!=null){
            ListNode curNext=curr.next;
            //遍历到最后一个节点了，他就作为新链表的头返回
            if (curNext==null){
                newHead=curr;
            }
            //交换前后关系
            curr.next=pre;
            pre=curr;
            //因为节点前后关系发生变化，想要先记录原来节点的位置，再改变(相当于引入temp做交换)
            curr=curNext;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(1);

        root.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=null;
        boolean res = isPalindrome(root);
        System.out.println(res);
    }
}
