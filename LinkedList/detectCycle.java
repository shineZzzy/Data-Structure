package LinkedList;
//找入环的第一个节点
public class detectCycle {
    public Node head;

    public Node detectCycle(){
        Node fast=this.head;
        Node slow=this.head;
        while (fast!=null||fast.next!=null){
            //先找到第一次相遇的结点
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                break;
            }
        }
        //当fast/fast.next为空时，说明没有
        if(fast==null||fast.next==null){
            return null;
        }
        //当第一次fast和slow相遇后，让slow回到表头，重新指向head
        slow=this.head;
        while (slow!=fast){
            //slow、fast未再次相遇时，俩指针同步走
            fast=fast.next;
            slow=slow.next;
        }
        //当fast和slow再次相遇，说明该结点为入环的第一个节点
        return slow;
    }
}
