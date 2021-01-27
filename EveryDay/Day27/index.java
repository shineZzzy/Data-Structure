package Test.Day27;
import java.util.Scanner;

//输入一组数 和一个数，得出该数的下标
public class index {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNext()) {
            int n=sc.nextInt();
            int[] k=new int[n];
            for (int i = 0; i <n ; i++) {
                k[i]=sc.nextInt();
            }
            int key=sc.nextInt();
            int index=getIndex(k,key);
            System.out.println(index);
        }

    }

    private static int getIndex(int[] k, int key) {
        for (int i = 0; i < k.length; i++) {
            if (k[i]==key){
                return i;
            }
        }
        return -1;
    }
}
