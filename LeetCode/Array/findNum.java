package offer.Array;

public class findNum {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows=matrix.length;
        int columns=matrix[0].length;
        boolean res=findNumber(matrix,rows,columns,target);
        return res;
    }
    private static boolean findNumber(int[][] m,int rows,int columns,int target){
        boolean sign=false;
        if (m!=null && rows>0 && columns>0 ){
            int row=0;
            int column=columns-1;

            while (row<rows && column>=0){
                if (m[row][row * column + column] == target){
                    sign=true;
                    break;
                }else if (m[row][row * column + column] > target){
                    column--;
                }else {
                    row++;
                }
            }
        }
        return sign;
    }
}
