package LinkedList;


public class MyLinkedList {
    public Node head;
    //头插
    public void addFirst(int val){
        Node node=new Node(val);
//        if(this.head==null){
//            this.head=node;
//        }else {
//           node.next=this.head;
//           this.head=node;
//        }
        node.next=this.head;
        this.head=node;
    }
    //尾插
    public void addLast(int val){
        Node node=new Node(val);

        //第一次插入
        if(this.head==null){
            this.head=node;
        }else {
            //不是第一次插入
            Node cur=this.head;
            while (cur.next != null) {

                cur = cur.next;
            }
            //cur.next==null时，cur走到尾巴了插入
            cur.next = node;
        }
    }

    //删除第一次出现
    public void removeFirst(int key){
        //如果链表为空，则没有要查找的值
        if(this.head == null){
            return;
        }
        //头结点为要删除的节点
        if(this.head.val == key){
            this.head=this.head.next;
            return;
        }
        //找到要删除节点的前驱节点
        Node cur=searchPrev(key);
        if(cur == null){
            System.out.println("没有找到要删除的节点");
            return;
        }
        //删除
        Node del=cur.next;
        cur.next=del.next;
    }

    //找前驱节点
    public Node searchPrev(int key){
        Node cur=this.head;
        while (cur.next != null) {
            if(cur.next.val==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }

    //查找是否包含关键字key在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

}
