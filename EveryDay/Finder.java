package Day1;

/**
 * 用快排思想，找出数组中指定元素的排名
 * 思路：
 * 1.先对数组逆序快排
 * 2.查找，返回有序数组中的index+1
 */
public class Finder {
    public static int findKth(int[] a, int n, int K) {
        quickSort(a,n);
        return a[K-1];
    }

    private static void quickSort(int[] a,int length) {
        quickSortInternal(a,0,length-1);
    }

    private static void quickSortInternal(int[] a, int lowIndex, int highIndex) {
        //出口
        int size=highIndex-lowIndex+1;
        if (size<=1){
            return;
        }
        int keyIndex=partition(a,lowIndex,highIndex);
        quickSortInternal(a,lowIndex,keyIndex-1);
        quickSortInternal(a,keyIndex+1,highIndex);
    }

    private static int partition(int[] a, int lowIndex, int highIndex) {
        int leftIndex=lowIndex;
        int rightIndex=highIndex;
        int key=a[leftIndex];
        while (leftIndex < rightIndex){
            while (leftIndex<rightIndex && a[rightIndex]<=key){
                rightIndex--;
            }
            while (leftIndex<rightIndex && a[leftIndex]>=key){
                leftIndex++;
            }
            swap(a,leftIndex,rightIndex);
        }
        swap(a,lowIndex,leftIndex);
        return leftIndex;
    }

    public static void swap(int[] a,int index1, int index2) {
        int temp=a[index1];
        a[index1]=a[index2];
        a[index2]=temp;
    }

//    public static void main(String[] args) {
//        int[] a={1,3,5,2,2};
//        quickSort(a,5);
//        System.out.println(Arrays.toString(a));
//    }

    public static void main(String[] args) {
        int[] a={1,3,5,2,2};
        int n=5;
        int k=3;

        System.out.println(findKth(a,n,k));

    }


}
