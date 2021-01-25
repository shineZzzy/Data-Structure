package Test.Day23;

import java.util.Scanner;

/**
 * 老师想知道从某某同学当中，分数最高的是多少，
 * 现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 */
public class maxScore {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//人数
            int a = sc.nextInt();//次数
            int[] src=new int[n];
            for (int i = 0; i < n; i++) {
                src[i]=sc.nextInt();
            }

            int max=0;
            for (int i = 0; i < a; i++) {
                String x=sc.next();
                int A=sc.nextInt();
                int B=sc.nextInt();
                score(x,A,B,src);
            }
        }
    }

    private static void score(String s,int a,int b,int[] n)  {
        int max=0;
        if(s.charAt(0)=='Q'){
            max=findMax(a,b,n);
            System.out.println(max);
        }else if(s.charAt(0)=='U'){
            update(a,b,n);
        }
    }

    private static void update(int a, int b, int[] src) {
        src[a]=src[b];
    }

    private static int findMax(int a, int b, int[] src) {
        int max=0;
        for (int i = a; i < b; i++) {
            if(src[i]>max){
                max=src[i];
            }
        }
        return max;
    }

}

//5 7
//        1 2 3 4 5
//        Q 1 5
//        U 3 6
//        Q 3 4
//        Q 4 5
//        U 4 5
//        U 2 9
//        Q 1 5
