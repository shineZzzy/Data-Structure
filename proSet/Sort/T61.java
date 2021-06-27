package LeetCode1.LIST.ListNode.T61_旋转链表;

import LeetCode1.LIST.ListNode.ListNode;

import java.io.IOException;

public class T61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        if(k == 0) return head;
        ListNode tail = head, newtail = head;
        ListNode newhead;
        int n = 1;
        // 原来的尾结点指向原来的头结点，形成环
        while(tail.next != null){
            tail = tail.next;
            n++;
        }
        tail.next = head;
        // 找到断开环的位置
        for(int i = 0; i < (n - k % n - 1); i++){
            newtail = newtail.next;
        }
        newhead = newtail.next;
        newtail.next = null;

        return newhead;
    }
    public static ListNode stringToListNode(int[] nums) {

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nums) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        int[] output={1,2};
        int k = 2;
        ListNode head = stringToListNode(output);
        ListNode ret = rotateRight(head, k);
        String out = listNodeToString(ret);

        System.out.print(out);
    }
}
