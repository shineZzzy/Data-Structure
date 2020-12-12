package Day16;

import java.util.Scanner;

//读入n个学生成绩
//输出指定分数的人数
public class score {
    public static int countS(int n,int[] a,int s){
        int count=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==s){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int N = scan.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < a.length; i++) {
                a[i] = scan.nextInt();
            }
            int sco=scan.nextInt();
            System.out.println(countS(N, a, sco));
        }
    }

}
