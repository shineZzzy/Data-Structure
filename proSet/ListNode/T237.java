package LeetCode1.LIST.ListNode.WEEK2;

import LeetCode1.LIST.ListNode.ListNode;

/**
 * 删除链表中的节点
 * TIP：实现一个函数，传入想要删除的节点，实现节点的删除不返回任何值。
 * 白话：让自己从世界上凭空消失，但又不是死亡---找个替身
 *      让自己成为他人，再干掉那个人！
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/comments/
 */
public class T237 {
    public static void deleteNode(ListNode node) {
        if(node==null){
            return;
        }
        //将当前值换成下一个节点的值，删掉下一个节点
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
