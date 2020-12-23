package test;

import java.util.Scanner;

/**
 * 满足多个测试用例：
 * 保证每组测试用例都在循环中
 */
public class Test {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while (true) {
            int n=s.nextInt();//换行符会让输入流接收数据
            for(int i=0;i<n;i++){
                int next=s.nextInt();
                System.out.println(next);
            }
        }
    }
}
