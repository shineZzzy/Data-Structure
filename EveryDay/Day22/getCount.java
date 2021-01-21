package Test.T0120;

import java.util.Scanner;
// 1 2 3 4 5 6 7 8 9 10 11 12
// 1 1 2 3 5 8 13 21
// count +=temp;
// temp=count-temp;

public class getCount {
    public static int getTotal(int month){
        int three=0;
        int one=1;
        int sen=0;
        int sum=0;
        if(month==1 || month==2){
            return 1;
        }else {
            for (int i=0;i<month;i++){
                    three +=sen;
                    sen=one;
                    one=three;
                    sum=three+sen;
                }

            }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int month=sc.nextInt();
        int res=getTotal(month);
        System.out.println(res);
    }
}
