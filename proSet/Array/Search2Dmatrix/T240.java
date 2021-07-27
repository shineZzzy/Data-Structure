package LeetCode1.EveryDAY.Array.BinarySearch.Search2Dmatrix;

/**
 * 搜索二维矩阵II
 * TIP：
 * 每行、每列分别构成有序
 * 区别与T74题，本题展开不是整体有序
 * 思路：
 * 从左上角开始查找，双指针移动坐标！
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class T240 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int column=matrix[0].length;
        if (rows==0 || column==0){
            return false;
        }

        int i=0,j=column-1;
        while (i<rows && j>=0){
            if (matrix[i][j]>target){
                j--;
            }else if (matrix[i][j]<target){
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix0={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix={{-5}};
        int target=-5;
        boolean res=searchMatrix(matrix,target);
        System.out.println(res);
    }
}
