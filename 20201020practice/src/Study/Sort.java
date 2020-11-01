package Study;

import sun.applet.resources.MsgAppletViewer;

public class Sort {
    public static void quickSort(long[] array) {
        quickSortInternal(array, 0, array.length - 1);
    }

    // 区间是 [lowIndex, highIndex]
    private static void quickSortInternal(long[] array,
                                          int lowIndex,
                                          int highIndex) {
        // 由于是闭区间，所以，区间内个个数需要加个 1
        int size = highIndex - lowIndex + 1;
        if (size <= 1) {
            return;
        }

        // 选择其中一个数（选最左边的） —— array[lowIndex]
        // 执行 partition，小的放左，大的放右
        // keyIndex 是经过 partition 之后，选出来的数最终所在下标
        int keyIndex = partition(array, lowIndex, highIndex);
        // 分别对左右区间进行相同的处理 —— 递归方法
        quickSortInternal(array, lowIndex, keyIndex - 1);
        quickSortInternal(array, keyIndex + 1, highIndex);
    }

    // 区间是 array[lowIndex, highIndex]
    // 1. 选择 array[lowIndex] 作为特殊的数
    // 2. 需要遍历整个区间（不能遗漏任何的数）和 选出来的数比较
    // 3. 保证 小于等于的在左边，大于等于的在右边（但没有顺序要求)
    private static int partition(long[] array, int lowIndex, int highIndex) {
        // 选择合适的方法
        return partitionHover(array, lowIndex, highIndex);
    }

    private static void swap(long[] array, int index1, int index2) {
        long t = array[index1];
        array[index1] = array[index2];
        array[index2] = t;
    }

    private static int partitionHover(long[] array, int lowIndex, int highIndex) {
        int leftIndex = lowIndex;
        int rightIndex = highIndex;
        // 选择的数是最左边的一个
        long key = array[lowIndex];
        // 选择了最左边，从右边先走

        // 停止条件 leftIndex == rightIndex
        // 循环的继续的条件 leftIndex < rightIndex
        while (leftIndex < rightIndex) {

            while (leftIndex < rightIndex && array[rightIndex] >= key) {
                rightIndex--;
            }
            // 说明 [rightIndex] 遇到了小的了

            while (leftIndex < rightIndex && array[leftIndex] <= key) {
                leftIndex++;
            }
            // 说明 [leftIndex] 遇到了大的了

            swap(array, leftIndex, rightIndex);
        }

        swap(array, lowIndex, leftIndex);

        return leftIndex;
    }
    private static int partitionPow(long[] array,int lowIndex,int highIndex){
        int leftIndex = lowIndex;
        int rightIndex = highIndex;
        // 选择的数是最左边的一个
        long key = array[lowIndex];
        // 选择了最左边，从右边先走
        while (leftIndex<rightIndex){
            while (leftIndex<rightIndex && array[rightIndex] >= key){
                rightIndex--;
            }
            array[leftIndex]=array[rightIndex];//填坑！！！

            while (leftIndex < rightIndex && array[leftIndex] <= key) {
                leftIndex++;
            }
            array[rightIndex]=array[leftIndex];
        }
        array[leftIndex]=key;
        return leftIndex;
//        return array;
    }

}
