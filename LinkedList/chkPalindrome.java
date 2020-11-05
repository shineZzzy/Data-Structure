package LinkedList;

public class chkPalindrome {
    /**
     * 链表的回文结构
     * 回文结构：从前往后走和从后往前走的顺序一致
     * 思路
     * 1.找到中间结点
     * 2.从中间结点后半部分开始反转(引用反转，不是结点交换)
     * 3.让两个引用同步分别从前从后走，直至相遇，判断前后引用的val是否相等
     */
    public Node head;
    public Boolean chkPalindrome(){
        if(this.head==null){
            return null;
        }
        if(this.head==null){
            return true;
        }
        //正常完整链表
        Node fast=this.head;
        Node slow=this.head;

        //找中间结点
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                break;
            }
        }
        //反转，将中间结点后半部反转
        Node cur=slow.next;
        while (cur!=null){
            Node curNext=cur.next;

            cur.next=slow;
            slow=cur;
            cur=curNext;
        }
        //指针同步走，比较data是否相等，一个从前一个从后，直至相遇
        //二者未相遇时
        while (this.head!=slow){
            //1
            if(this.head.val!=slow.val){
                return false;
            }
            //如果链表结点为偶数时，也许head.next==slow
            //2.
            if(this.head.next==slow){
                return true;
            }
            //1.2存在次序，当1不满足才会判断2
            this.head=this.head.next;
            slow=slow.next;
        }
        return true;
    }









}
