package LeetCode.恒生电子.T1;

public class Main {
    public static void main(String[] args) {
        int triangle[][] = new int[12][];//创建一个二维数组来存储杨辉三角形
        for (int i = 0; i < 12; i++) {
            //确定每一行数组的长度
            triangle[i] = new int[i+1];
            //得到杨辉三角形的值
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            if(i>1){
                for (int j = 1; j < i; j++) {
                    triangle[i][j] = triangle[i-1][j-1]+triangle[i-1][j];
                }
            }
        }
        //输出与格式规范
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9-i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < i+1; j++) {
                System.out.printf("%4d",triangle[i][j]);
            }
            System.out.println(" ");
        }

    }
}
