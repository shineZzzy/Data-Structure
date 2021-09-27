package Leet2021_09.T06;
import java.util.Arrays;
/**
 * 从尾巴打印链表
 * 思想：回溯
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class T06_2 {
    public static int[] res;
    public static int i = 0;
    public static int j = 0;
    public static int[] reversePrint(ListNode head) {
        solve(head);
        return res;
    }
    public static void solve(ListNode head){
        if(head == null){
            //开辟空间
            res = new int[i];
            return;
        }
        //统计节点个数
        i++;
        //递归到最后一个节点
        solve(head.next);
        //存储当前节点的值
        res[j] = head.val;
        //记录存储位置
        j++;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode a=new ListNode(3);
        ListNode b=new ListNode(2);
        head.next=a;
        a.next=b;
        b.next=null;
        int[] res = reversePrint(head);
        System.out.println(Arrays.toString(res));

    }
}
