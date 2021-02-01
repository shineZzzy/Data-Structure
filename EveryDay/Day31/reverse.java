package Test.Day31;

import java.util.Scanner;
import java.util.Stack;

public class reverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            getReverse(s);
        }
    }

    private static void getReverse(String s) {
        Stack<String > stack=new Stack<>();
        String[] str=s.split(" ");
        for (String s1:str) {
            stack.push(s1);
        }
        for (int i = 0; i <str.length ; i++) {
            System.out.print(stack.pop()+" ");
        }
    }
}

//        String[] s1=new String[stack.size()];
//        for (int i = 0; i < s1.length; i++) {
//            s1[i]=stack.pop();
////            System.out.print(stack.pop()+" ");
//        }
//        System.out.println(Arrays.toString(s1)+" ");
