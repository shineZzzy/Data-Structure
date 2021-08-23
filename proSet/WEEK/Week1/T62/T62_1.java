package LeetCode.剑指offer.Week1.T62;

public class T62_1 {
    public static int lastRemaining(int n, int m) {
        if (n==0 || m==0){
            return 0;
        }
        int res=0;
        for (int i = 2; i <= n; i++) {
            res=(res+m)%i;
        }
        return res;
    }

    public static void main(String[] args) {
        int m=3;
        int n=5;
        int res = lastRemaining(m, n);
        System.out.println(res);
        int[][] nums={{1,2},{2,3}};

    }
}
