package Java;

import java.util.Stack;
/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 思路：
 * 1.用stack1的入栈实现入队
 * 2.用stack2的出栈实现出队
 * 3.中间需要将stack1的元素全部转移至stack2中，再完成出栈
 * 考察：栈和队列的特点
 * 栈：先进后出       队列：后进先出
 */
public class stackN {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        //先将stack1的元素转移至stack2,再出栈
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.peek());
            }
        }
        return stack2.pop();
    }
}
