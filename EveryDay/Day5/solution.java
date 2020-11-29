package Day5;

import java.util.Stack;

public class solution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //1.入队
    public void push(int node) {
        stack1.push(node);
    }
    //2.出队
    public int pop() {
        //1.当stack2为空时，stack1的元素压栈，stack2再出栈
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
