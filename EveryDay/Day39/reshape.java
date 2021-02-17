package Test.Day39;
import java.util.Arrays;

/**
 * 回忆机器学习中，多维数组的处理：flatten
 * 重点是确定新数组中的位置！
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix/comments/
 */
public class reshape {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m=nums.length;
        int n=nums[0].length;
        if(m*n !=r*c){
            return nums;
        }
        int[][] ans=new int[r][c];
        for (int i = 0; i <m*n; i++) {
            ans[i/c][i%c]=nums[i/n][i%n];
        }

        return ans;
    }
    //ans[1/4][1%4]=nums[i/2][1%2]
    //ans[0][1]=nums[0][1]
    public static void main(String[] args) {
        int[][] n ={{1,2},{3,4}};
        int r=1;
        int c=4;
        int[][] m=matrixReshape(n,r,c);
        System.out.println(Arrays.deepToString(m));
    }
}
