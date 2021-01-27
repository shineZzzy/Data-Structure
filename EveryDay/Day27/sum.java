package Test.Day27;
import java.util.Scanner;

//输入一个数，计算该数各个位置上的数字和，以及它的平方数的数字和
public class sum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int squ=n*n;
            int s= sumN(n);
            int res= sumN(squ);
            System.out.println(s+" "+res);

        }
    }
    public static int sumN(int x){
        int sum=0;
        while(x>0){
            sum += x%10;
            x = x/10;
        }
        return sum;
    }
}
