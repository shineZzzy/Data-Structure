package Day2;

/**
 * 对一组数，其中任意两个数组
 * 若前一个数>后一个数=逆序对
 * 计算给定数组中的逆序对、
 * 思路：
 * 1.划分随机数组
 * 2.前后比较？
 *
 *
 */
public class AntiOrder {
    public static int count(int[] A,int n) {
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(A[j]<A[i]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A={1,2,3,4,5,6,7,0};
        int n=8;
        System.out.println(count(A,n));
    }

}
