package Test.Day40;

public class addTowNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建新链表的伪头节点
        ListNode head=new ListNode(0);
        ListNode curr=head;
        //记录进位：满十进一
        int carry=0;
        while (l1!=null || l2!=null){
            //当l1 l2各不为空时的值
            int n1=l1!=null?l1.val:0;
            int n2=l2!=null?l2.val:0;
            //求和
            int sum=carry+n1+n2;
            //更新carry
            carry=sum/10;
            //确定下一个结点的位置，及其值
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            //当l1 或 l2不为空时，继续往后走
            //若有一个为空，则将另一个的值按序补在新链表后面
            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
        }
        //如果链表遍历结束后，有 carry>0，还需要在答案链表的后面附加一个节点，节点的值为carry。
        if (carry>0){
            curr.next=new ListNode(carry);
        }
        //返回新链表的头节点
        return head.next;
    }
}
