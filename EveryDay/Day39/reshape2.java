package Test.Day39;
import java.util.Arrays;

public class reshape2 {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m=nums.length;
        int n=nums[0].length;
        if(m*n !=r*c){
            return nums;
        }
        int[][] ans=new int[r][c];
        int count = 0;// 表示按行遍历时，在数组中的第几个位置
        for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            ans[i][j] = nums[count / n][count % n];
            count++;
        }
    }

        return ans;
    }






    public static void main(String[] args) {
        int[][] n ={{1,2},{3,4}};
        int r=1;
        int c=4;
        int[][] m=matrixReshape(n,r,c);
        System.out.println(Arrays.deepToString(m));
    }
}
