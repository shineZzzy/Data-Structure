package LeetCode1.LIST.ListNode.offer;
import LeetCode1.LIST.ListNode.ListNode;

/**
 * 合并两个排序链表
 * TIP:将两个升序链表进行合并，合并后仍为升序
 * 思路：双指针遍历，比较节点大小，小的加入结果集，最后将较长的链表剩余部分加入结果集
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
public class T25 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null){
            return null;
        }
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }

        ListNode newHead=new ListNode(-1);
        ListNode cur=newHead;

        while (l1!=null && l2!=null){
            if (l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }

        if (l1!=null){
            cur.next=l1;
        }else {
            cur.next=l2;
        }
        return newHead.next;
    }
}
