package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public int[][] merge(int[][] a){
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        ArrayList<int[]> list=new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int[] arr=a[i];
            if (list.isEmpty()){
                list.add(arr);
            }else {
                int[] c=list.get(list.size()-1);
                int right=c[1];
                int curLeft=arr[0];
                if (right<curLeft){
                    list.add(arr);
                }else {
                    int curRight=arr[1];
                    c[1]=Math.max(right,curRight);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
