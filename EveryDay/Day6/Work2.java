package Day6;

import java.util.Scanner;

/**
 * 输入n个数，输出出现次数大于数组长度的数
 */
public class Work2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String[] s=scan.nextLine().split(" ");
            int[] a=new int[s.length];
            for(int i=0;i<s.length;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            int count=0;
            int max=0;
            int i;
            for(i=0;i<a.length-1;i++){
                for (int j=i;j<a.length-1;j++){
                    if(a[i]==a[j]){
                        count++;
                    }
                }
                if(count>max){
                    max=count;
                    count=0;
                }
            }

            if(max>a.length/2){
                System.out.println(a[i]);
            }
        }
    }
}
