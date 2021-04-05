package DataStructure.Test.leetcode.Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用一个双端队列实现栈
 * 思路：利用双端队列的可栈、可队列的特性。
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class MyStack1 {
    private Deque<Integer> deque;
    public MyStack1() {
        deque =new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deque.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return deque.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        MyStack2 m2=new MyStack2();
        m2.push(1);
        m2.push(2);
        System.out.println(m2.top());
        System.out.println(m2.pop());

        System.out.println(m2.empty());
    }
}
