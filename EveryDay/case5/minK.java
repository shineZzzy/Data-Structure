package EveryDay.offer.TreeNode.case5;
import java.util.ArrayList;


/**
 * 最小的K个数
 * 思路：用数组建大小为K的大根堆，
 * 找堆顶元素与数组其余元素i比较，如果堆顶>i，交换并重新调整堆，重复至最终堆中元素为数组中最小的K个元素
 * 感悟：这个题已经困扰我很久了，从最开始的没有一毛钱思路，到今天终于做出了。
 * 虽然代码写的很烂，有些处理很蠢，但是，我写出来了，总得硬着头皮去做，至少比面试时厚着脸皮说不会好吧！
 * 时间的确很紧迫，但是，别着急，慢慢来，这样才会快一点！
 * 链接：https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 */
public class minK {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        if (k>input.length||input.length==0||input==null || k==0){
            return res;
        }
        int[] a=new int[k];
        for (int i = 0; i < k; i++) {
            a[i]=input[i];
        }
        creatHeap(a,k);
//        int[] arr=new int[input.length-k+1];
//        for (int i = k+1; i <input.length; i++) {
//            arr[i]=input[i];
//        }
//        Arrays.sort(arr);
        for (int i = k; i < input.length; i++) {
            if (a[0]>input[i]){
                a[0]=input[i];
                adjustDown(a,k,0);
            }
        }

        for (int i = 0; i < a.length; i++) {
            res.add(a[i]);
        }
        return res;

    }

    private static void creatHeap(int[] input, int k) {
        if (input==null || input.length==0 || input.length==1){
            return;
        }
        int lastIndex=k-1;
        int lastParent=(lastIndex-1)/2;
        for (int i=lastParent;i>=0;i--){
            adjustDown(input,k,i);
        }

    }

    private static void adjustDown(int[] a, int k, int i) {
        if (a.length==1 || a.length==0 || a==null){
            return;
        }
        //先找到左孩子叶节点
        while (true) {
            int left=2*i+1;
            if(left>k){
                return;
            }
            int max=left;
            int right=max+1;
            if (right<k && a[right]> a[max]){
                max=right;
            }
            if (a[i]>=a[max]){
                break;
            }
            swap(a,max,i);
            i=max;
        }
    }

    private static void swap(int[] a, int j, int i) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr={4,5,1,6,2,7,3,8};
        int k=10;
        ArrayList<Integer> res=GetLeastNumbers_Solution(arr,k);
        System.out.println(res);
    }
}
