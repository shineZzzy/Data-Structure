package 栈和队列;

//输入两个整数序列
//第一个序列表示栈的压入顺序，
//请判断第二个序列是否可能为该栈的弹出顺序。

import java.util.Stack;

/**
 * 将A序列元素压栈，出栈存储在数组中，与B序列遍历比较
 * 两个指针i j
 * 1.长度是否相等，不等false
 */
public class checkStack {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> s=new Stack<>();
        int lenA=pushA.length;
        //将pushA元素入栈，将栈顶元素与pushB元素进行比较
        //如果是，就出栈
        //循环完成后，进一步判断存储pushA的栈是否为空
        int[] a=new int[lenA];
        int j=0;
        for(int i=0;i<lenA;i++){
            a[i]=s.push(pushA[i]);
            while (j<lenA && s.peek()==popA[j]){
                a[j]=s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }
}
