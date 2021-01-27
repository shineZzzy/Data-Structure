package Test.Day27;

import java.util.Scanner;

class Person{
    String name;
    int count;

    public Person(String name, int count) {
        this.name = name;
        this.count = count;
    }
}
public class devote {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            System.out.print("请输入人数:");
            int n=sc.nextInt();
            System.out.println("请输入编号：");
            String s=sc.next();
            System.out.print("请输入投票人数:");
            int m=sc.nextInt();
            System.out.println("请输入投票编号：");
            String s1=sc.next();

//            vote(n,s,m,s1);
        }
    }
}
