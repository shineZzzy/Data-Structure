package Leet2021_09.T06;
/**
 * 从尾巴打印链表
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */

import java.util.Stack;
public class T06_1 {
    //方法1：利用栈先进后出的原理
    public static int[] reversePrint_1(ListNode head) {
        if (head==null){
            return new int[]{};
        }
        Stack<Integer> stack=new Stack<>();
        ListNode cur=head;
        while (cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }

        int[] res=new int[stack.size()];
        int i=0;
        while (!stack.isEmpty()){
            res[i++]=stack.pop();
        }
        return res;
    }

}
