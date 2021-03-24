package DataStructure.Test;
import java.util.*;

/**
 * 反转链表
 * 思路：利用栈先进后出的特点
 * 1.第1次边遍历边入栈
 * 2.再将结点全部出栈
 * 3.返回头节点
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=188&tqId=38029&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 */
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        Stack<ListNode> stack=new Stack<>();
        for(ListNode cur=head;cur!=null;cur=cur.next){
            stack.push(cur);
        }
        if(stack.isEmpty()){
            return null;
        }
        ListNode newHead=null;
        ListNode cur=stack.pop();
        newHead=cur;
        while(!stack.isEmpty()){
            ListNode t=stack.pop();
            cur.next=t;
            cur=cur.next;
        }
        cur.next=null;
        return newHead;

    }
}
