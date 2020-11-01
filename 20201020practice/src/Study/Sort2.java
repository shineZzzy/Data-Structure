package Study;

public class Sort2 {
    private static void swap(long[] array, int index1, int index2) {
        long t = array[index1];
        array[index1] = array[index2];
        array[index2] = t;
    }
    public static void 分割(long[] array){
        int leftIndex = 0;
        int rightIndex = array.length-1;
        // 选择的数是最左边的一个
//        long key = array[leftIndex];
        while (leftIndex<rightIndex){
            while (leftIndex<rightIndex && array[leftIndex]%2!=0){
                leftIndex++;
            }
            while (leftIndex<rightIndex && array[rightIndex]%2==0){
                rightIndex--;
            }
            swap(array,leftIndex,rightIndex);
        }
//        swap(array,leftIndex,rightIndex);

//        return array;

    }
}
