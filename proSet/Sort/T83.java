package LeetCode1.LIST.ListNode.T82;

import LeetCode1.LIST.ListNode.ListNode;
import java.io.IOException;

/**
 * 删除链表重复元素
 * tip:使每个元素只出现一次
 * 思路：指针遍历
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */

public class T83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }

        ListNode cur=head;
        while (cur!=null && cur.next!=null){
            if (cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return head;
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
        int[] output={1,1,1,3,4,5};
        ListNode head = stringToListNode(output);
        ListNode ret = deleteDuplicates(head);
        String out = listNodeToString(ret);

        System.out.print(out);
    }
}
