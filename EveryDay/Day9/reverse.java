package Day9;

import java.util.Scanner;
import java.util.Stack;

/**
 * 输入一个整数，将其以字符串形式逆序输出
 *  1516000
 */
public class reverse {
    public static void revString(String n){
        char[] c=n.toCharArray();
        Stack<Character>stack=new Stack<>();
        for(int i = 0; i<c.length;i++){
            stack.push(c[i]);
        }
        String s="";

        while (!stack.isEmpty()){
            s+=stack.pop();
        }
        System.out.println(s);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String s=scan.nextLine();
            revString(s);
        }
    }
}
