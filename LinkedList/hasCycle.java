package LinkedList;

public class hasCycle {
    private Node head;
    public boolean hasCycle(){
        Node fast=this.head;
        Node slow=this.head;

        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return false;
        }
        return true;
    }
}
