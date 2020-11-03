package LinkedList;

public class MiddleNode {
    public Node head;

    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast!=null && fast.next!=null){

            fast=fast.next.next;
            slow=slow.next;
            }
        return slow;
    }

}
