package DataStructure.Test.leetcode.Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.StringJoiner;

/**
 * 用两个双端队列实现栈
 */
public class MyStack2 {
    private Deque<Integer> deq1;
    private Deque<Integer> deq2;

    @Override
    public String toString() {
        return new StringJoiner(", ", MyStack2.class.getSimpleName() + "[", "]")
                .add("deq1=" + deq1)
                .add("deq2=" + deq2)
                .toString();
    }

    /** Initialize your data structure here. */
    public MyStack2() {
        deq1=new LinkedList<>();
        deq2=new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        deq1.add(x);
        int size=deq1.size();
        for (int i=0;i<size;i++){
            deq2.addFirst(deq1.removeLast());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deq2.removeFirst();
    }

    /** Get the top element. */
    public int top() {
        return deq2.getFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deq2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack2 m2=new MyStack2();

        m2.push(1);
        m2.push(2);

        System.out.println(m2);

    }
}
