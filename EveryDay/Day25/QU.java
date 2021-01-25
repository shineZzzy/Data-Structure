package Test.Day23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QU {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//人数
            int a = sc.nextInt();//次数
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            for (int i = 0; i <a; i++) {
                String s=sc.next();
                int A=sc.nextInt();
                int B=sc.nextInt();
//                System.out.println();
                score(list, A, B, s);
            }
        }
    }
    private static void score(List<Integer> list, int a, int b, String s) {
        if (s.charAt(0)=='Q'){
            int max=getMax(list,a,b);
            System.out.println(max);
        }else if(s.charAt(0)=='U'){
            upDate(list,a,b);
        }
    }

    private static void upDate(List<Integer> list, int a, int b) {
        int index=a-1;
        list.set(index,b);
//        System.out.println(list);
    }

    private static int getMax(List<Integer> list, int a, int b) {
        int max=list.get(0);
        for (int i = a-1; i <b; i++) {
            if(list.get(i)>max){
                max=list.get(i);
            }
        }
        return max;
    }

}

