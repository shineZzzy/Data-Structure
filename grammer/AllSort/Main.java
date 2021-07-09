package AllSort;

import Study.Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long[] array=BuildArray.随机数组();
        System.out.println(Arrays.toString(array));
        Sort6.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
