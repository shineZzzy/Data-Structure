package offer.week1;

public class T04_1 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null ||matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int rows=matrix.length;
        int columns=matrix[0].length;
        int i=0,j=columns-1;
        while(i<rows && j>=0){
            if (matrix[i][j]==target){
                return true;
            }else if (matrix[i][j]>target){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}
