package DataStructure.Test.leetcode.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用一个普通队列实现栈
 */
public class MyStack {
    private Queue<Integer> queue;
    public  MyStack() {
        queue=new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size=queue.size();
        for (int i = 0; i < size - 1; i++) {
            Integer e=queue.remove();
            queue.add(e);
        }
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        int size=queue.size();
        for (int i = 0; i < size - 1; i++) {
            Integer e=queue.remove();
            queue.add(e);
        }
        Integer t=queue.remove();
        queue.add(t);
        return t;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack2 m2=new MyStack2();
        m2.push(1);
        m2.empty();
    }
}
