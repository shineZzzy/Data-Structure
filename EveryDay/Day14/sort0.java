package Day14;

import java.util.Scanner;

public class sort0 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String[] s=sc.nextLine().split(" ");
            int[] a=new int[s.length];
            for(int i=0;i<s.length;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            sort(a);
            int start=0;
            int next=1;
            if(a[start]==0){
                while (a[next]==0) {
                    next++;
                }
                if(a[next]!=0){
                    swap(a, start, next);
                }
            }
//            System.out.println(Arrays.toString(a));
            for(int i=0;i<a.length;i++){
                System.out.print(a[i]);
            }
        }

    }

    private static void swap(int[] a,int start, int next) {
        int temp=a[start];
        a[start]=a[next];
        a[next]=temp;
    }

    private static void sort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            int key=a[i+1];
            int j=0;
            for(j=i;j>=0;j--){
                if(key<a[j]){
                    a[j+1]=a[j];
                }else {
                    break;
                }
            }
            a[j+1]=key;
        }
    }
}
