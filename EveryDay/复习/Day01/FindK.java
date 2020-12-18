package Day01;

import java.util.Scanner;

/**
 * 寻找第K大
 *
 */
public class FindK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            String s=str.substring(1,str.length()-5);
            int[] a=new int[s.length()];
            for (int i=0;i<s.length();i++){
                a[i]=s.charAt(i);
            }
            System.out.println(s);
            String s2=str.substring(str.length()-3,str.length()-2);
            int n=Integer.parseInt(s2);
            int k=Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));
            //partition
            System.out.println(findKth(a, n, k));

        }
    }

    private static int findKth(int[] a, int n, int k) {
        return findKthInternational(a,0,n-1,k);
    }

    private static int findKthInternational(int[] a, int low, int high, int k) {
        int part=partation(a,low,high);
        if (k==part-low+1){
            return a[part];
        }else if(k>part-low+1){
            return findKthInternational(a,part+1,high,k-part+low-1);
        }
        return findKthInternational(a, low, part -1, k);
    }
    public static int partation(int[] a, int low, int high) {
        int key = a[low];
        while(low < high) {
            while(low < high && a[high] <= key) high--;
            a[low] = a[high];
            while(low < high && a[low] >= key) low++;
            a[high] = a[low];
        } a
                [low] = key;
        return low;
    }
}
