package Test.Day32;

import java.util.Scanner;

public class change {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String P=sc.next();
            String A=sc.next();
            getChange(P,A);

        }
    }

    private static void getChange(String p, String a) {
        int g=0;
        int k=0;
        int s=0;
        String[] s1=p.split("\\.");
        String[] s2=a.split("\\.");
        int p1=Integer.parseInt(s1[0])*17*29+Integer.parseInt(s1[1])*29+Integer.parseInt(s1[2]);
        int a1=Integer.parseInt(s2[0])*17*29+Integer.parseInt(s2[1])*29+Integer.parseInt(s2[2]);
        int temp=a1-p1;
        if(a1<p1){
            System.out.print("-");
            temp=-temp;
        }
        g=temp/(17*29);
        s=(temp-(g*17*29))/29;
        k=temp%29;
        System.out.println(g+"."+s+"."+k);
    }
}

//10.16.27 14.1.28
//4930+464+27=5421
//6920+29+28=6959
//t=1538//3.