package LeetCode1.LIST.ListNode.T138;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class T138 {
    public static Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }
        
        Map<Node,Node> node =new HashMap<>();
        Map<Node,Node> random=new HashMap<>();
        Node cur=head;
        while (cur!=null){
            node.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            node.get(cur).next=node.get(cur.next);
            node.get(cur).random=node.get(cur.random);
            cur=cur.next;
        }
        return node.get(head);
    }
}
