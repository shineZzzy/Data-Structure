package LeetCode1.LIST.ListNode.T82;

import LeetCode1.LIST.ListNode.ListNode;
import java.io.IOException;

/**
 * 删除重复元素II
 * TIP：只保存不重复的元素
 * 思路：双指针指针
 * 一个记录前驱，一个遍历遇到相同元素就继续走，遇到下一个不同的元素，改变前后继关系
 * (不用过多指针，否则多了就看不清了)
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */

public class T82_1 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode newHead=new ListNode(-1);
        newHead.next=head;
        ListNode prev=newHead;
        ListNode cur=head;

        while (cur!=null && cur.next!=null){
            if (cur.val==cur.next.val){
                //遇到相同元素，找其重复的终点
                while (cur.next!=null && cur.val==cur.next.val){
                    cur=cur.next;
                }
                //跳过相同元素，重新拼接
                prev.next=cur.next;
                cur=cur.next;
            }else {
                //不重复元素，指针向后走
                prev=prev.next;
                cur=cur.next;
            }
        }
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
        int[] output={1,1,1,3,4,5};
        ListNode head = stringToListNode(output0);
        ListNode ret = deleteDuplicates(head);
        String out = listNodeToString(ret);

        System.out.print(out);
    }
}

