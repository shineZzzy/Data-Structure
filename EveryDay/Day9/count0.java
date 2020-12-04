package Day9;

import java.util.Scanner;

public class count0 {
    public static int countN(long n){
        int count=0;
        String s=String.valueOf(n);
        char[] c=new char[s.length()+1];
        for(int i=0;i<s.length();i++){
            c[i]=s.charAt(i);
        }
        System.out.println(c);
        for (int i=0;i<c.length;i++) {
            if (c[i]=='0') {
                 count++;
            }
        }
        return count;
    }
    public static long resN(int n){

        if(n==0||n==1){
            return 1;
        }
        return n*resN(n-1);
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int n=scan.nextInt();
            long res=resN(n);

            System.out.println(countN(res));
        }
    }
}
