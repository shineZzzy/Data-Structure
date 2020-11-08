package 实验报告;

import java.util.Scanner;

//不使用累计乘法的基础上
//通过移位运算（<<）实现2的n次方的计算。
public class Test15 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        long a=0;
        while (scan.hasNext()){
            a=scan.nextLong();
            long c=2<<(a-1);
            System.out.println(c);
        }
        scan.close();
    }
}
