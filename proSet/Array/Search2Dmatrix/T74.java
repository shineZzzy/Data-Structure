package LeetCode1.EveryDAY.Array.BinarySearch.Search2Dmatrix;

/**
 * 搜索二维矩阵
 * TIP:排序二维矩阵
 * 每一行的第一个元素>上一行最后一个元素，展开成一维后仍然是升序数组
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class T74 {
    public static void main(String[] args) {
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target=3;
        boolean res=searchMatrix(matrix,target);
        System.out.println(res);
    }
    //将二维展开成一维处理
    private static boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int column=matrix[0].length;
        if(rows==0 || column==0){
            return false;
        }
        int l=0,r=rows*column-1;
        while (l<r){
            int mid=(l+r)/2;
            //定位target坐标
            if (matrix[mid/column][mid%column]>=target){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        if (matrix[r / column][r % column]!=target){
            return false;
        }
        return true;
    }

}
