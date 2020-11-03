package LinkedList;

public class deleteRepeat {
    public Node deleteDuplication(Node pHead){
        Node newNode=new Node(-1);
        Node tmp=newNode;
        Node cur=pHead;
        while (cur!=null){
            if(cur.next!=null && cur.val==cur.next.val){
                while (cur.next!=null && cur.val==cur.next.val){
                    cur=cur.next;
                }
                cur=cur.next;
            }else {
                tmp.next=cur;
                tmp=cur;
                cur=cur.next;
            }
        }
        tmp.next=null;
        return newNode.next;
    }

}
