package LinkedList;

public class Partition {
    public Node head;
//    //获取链表长度
//    public int getLength(){
//        int count=0;
//        Node cur=this.head;
//        while (cur!=null){
//            count++;
//            cur=cur.next;
//        }
//        return count;
//    }
    public Node partition(Node head, int x) {
        //pHead 头指针

        Node bs=null;
        Node be=null;

        Node as=null;
        Node ae=null;
        Node cur=this.head;
        while (cur!=null){

            if(cur.val<x) {
                //第一次插入
                if (bs == null) {
                    bs = cur;
                    be = bs;
                } else {
                    //不是第一次插入
                    be.next = cur;
                    be = cur;
                }
                //cur.val>x
            }else {
                if(as==null){
                    as=cur;
                    ae=as;
                }else {
                    ae.next=cur;
                    ae=cur;
                }
            }
            cur=cur.next;
        }
        //也许有一部分为空
        if(be==null){
            return as;
        }
        //连接两头=”合并“
        be.next=as;
        //避免死循环，当as!=null时，将ae.next置为null;
        if(as!=null){
            ae.next=null;
        }
        //返回bs头结点
        return bs;
    }
}
