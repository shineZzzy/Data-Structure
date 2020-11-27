package Day3;

import java.util.Scanner;
import java.util.Stack;

/**
 * 用栈：遇到左括号入栈，右括号出栈
 */
public class demo2 {
    public static boolean containC(String A, int n) {
        Stack<Character>stack=new Stack<>();
        //(((())))
        for(int i=0;i<n;i++){
            //遇到左括号入栈
            if(A.charAt(i)=='('){
                stack.push(A.charAt(i));
                //遇到右括号出栈
            }else if(A.charAt(i)==')'){
                //1.若右括号出现时，但栈为空，false
                if(stack.empty()){
                    return false;
                }
                //2.若栈顶为左括，当前元素为右括，true
                if(stack.peek()=='('&& A.charAt(i)==')') {
                    stack.pop();
                }
                //若输入不是左右括号的字符时
            }else if(A.charAt(i)!='('||A.charAt(i)!=')'){
                return false;
            }
        }
        //最后栈为空！
        if(stack.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        int n=scan.nextInt();
        System.out.println(containC(s,n));
    }
}
