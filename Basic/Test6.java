package 实验报告;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//针对每组输入，反向输出对应四位数。
public class Test6 {
    public static int[] getDigits(long n){
        Deque<Integer> stack=new LinkedList<>();
        while (n>0){
            //取余
            int m=(int)(n%10);
            n=n/10;
            //压栈
            stack.push(m);
            System.out.print(m);
        }
        //出栈
        int[] array=new int[stack.size()];
        for(int i=0;i<array.length;i++){
            array[i]=stack.pop();
        }
        return array;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        long n=scan.nextLong();
        getDigits(n);

    }
}
