package DataStructure.LinkedList;

public class LinkedList implements List{
    public Node head;
    public Node tail;
    public int size;


    @Override
    public boolean add(Integer e) {
        //1.判断链表中是否有结点
        Node node=new Node(e);
        if (size==0){
            this.head=this.tail=node;
        }else {
            //2.尾插
            this.tail.next=node;
            node.prev=this.tail;
            this.tail=node;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, Integer e) {
        //1.合法性检验
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("下标越界："+index);
        }
        if(index==size){
            //尾插
            add(e);
        }else if (index==0){
            //头插
            Node node=new Node(e);
            node.next=this.head;
            this.head.prev=node;
            this.head=node;
            size++;
        }else {
            //中间
            //离head近，找到index-1位置
            Node prev;
            if (index-1<size/2){
                prev=head;
                for (int i = 0; i < index - 1; i++) {
                    prev=prev.next;
                }
            }else {
                //离tail近，找到(size-1)-(index-1)位置
                prev=tail;
                for (int i = 0; i < size - index; i++) {
                    prev=prev.prev;
                }
            }
            Node next=prev.next;
            Node node=new Node(e);

            node.prev=prev;
            node.next=next;
            prev.next=node;
            next.prev=node;

            size++;
        }
    }

    @Override
    public int remove(int index) {
        //1.合法性检验
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("下标越界："+index);
        }
        //2.根据下标确定删除位置
        Integer v;
        if (index==0){
            v=this.head.element;
            this.head=this.head.next;
            this.head.prev=null;
            size--;
            if (size==0){
                this.tail=null;
            }
        }else if (index==size-1){
            v=this.tail.element;
            this.tail=this.tail.prev;
            this.tail.next=null;
            size--;
            if (size==0){
                this.head=null;
            }
        }else {
            //看离头/尾近  找index-1(prev)位置
            Node prev;
            if (index-1<size/2){
                prev=head;
                for (int i = 0; i < index - 1; i++) {
                    prev=prev.next;
                }
            }else {
                prev=tail;
                for (int i = 0; i < size - index; i++) {
                    prev=prev.prev;
                }
            }

            Node toRemove=prev.next;
            v=toRemove.element;
            prev.next=toRemove.next;
            toRemove.next.prev=prev;
            size--;
        }
        return v;
    }

    @Override
    public boolean remove(Integer e) {
        Node prev = null;
        for (Node cur = head; cur != null; prev = cur, cur = cur.next) {
            if (cur.element.equals(e)) {
                if(prev == null) {
                    remove(0);
                    return true;
                } else {
                    prev.next.next.prev = prev;
                    prev.next = prev.next.next;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        //1.合法性检验
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("下标越界："+index);
        }
        //2.遍历去找下标，链表只需要直到头节点就可以顺着找到任何元素
        Node cur=head;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }

        return cur.element;
    }

    @Override
    public Integer set(int index, Integer e) {
        //1.合法性检验
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("下标越界："+index);
        }
        //遍历找到下标位置，将值改掉,并返回原来的值
        Node cur=head;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        Integer v=cur.element;
        cur.element=e;
        return v;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Integer e) {
//        int i=0;
//        for (Node cur=head;cur!=null;cur=cur.next,i++){
//            if (cur.element.equals(e)){
//                return true;
//            }
//        }
//        return false;
        return indexOf(e)!=-1;
    }

    @Override
    public int indexOf(Integer e) {
        int i=0;
        for (Node cur=head;cur!=null;cur=cur.next,i++){
            if (cur.element.equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        int i=size-1;
        for (Node cur=tail;cur!=null;cur=cur.prev,i--){
            if (cur.element.equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator(this);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        for (Node cur=head;cur!=null;cur=cur.next){
            sb.append(cur.element);
            if (cur!=tail){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();

    }
}
