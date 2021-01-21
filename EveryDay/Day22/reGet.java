package Test.T0120;

import java.util.Scanner;

public class reGet {
    public static int getTotals(int month){
        if (month==1 || month==2){
            return 1;
        }else {
            return getTotals(month-1)+getTotals(month-2);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int month=sc.nextInt();
            System.out.println(getTotals(month));
        }

    }
}
