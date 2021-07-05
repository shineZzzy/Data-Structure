package LeetCode1.LIST.ListNode.T86;

import LeetCode1.LIST.ListNode.ListNode;
import java.io.IOException;

/**
 * 分隔链表
 * 思路：双指针+合并
 * 重新开辟两条链表，分别存储大于和小于x的节点，然后进行合并
 * 链接：https://leetcode-cn.com/problems/partition-list/
 */

public class T86_1 {
    public static ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }
        ListNode newHead=new ListNode(-1);
        ListNode left=newHead;

        ListNode newLarge=new ListNode(-1);
        ListNode right=newLarge;


        while (head!=null){
            if (head.val>=x){
                right.next=head;
                right=right.next;

            }else {
                left.next=head;
                left=left.next;
            }

            head=head.next;
        }
        right.next=null;
        left.next=newLarge.next;
        return newHead.next;
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

        StringBuilder result = new StringBuilder();
        while (node!= null) {
            result.append(Integer.toString(node.val)).append(", ");
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }


    public static void main(String[] args) throws IOException {
        int[] output0={1,2,3,3,4,4,5};
        int[] output={1,4,3,2,5,2};
        ListNode head = stringToListNode(output);
        ListNode ret = partition(head,3);
        String out = listNodeToString(ret);

        System.out.print(out);
    }
}
