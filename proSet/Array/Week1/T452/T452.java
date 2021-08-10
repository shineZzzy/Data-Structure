package SuanFa.Tanxin.T452;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T452 {
    public static int findMinArrowShots(int[][] points) {
        int len=points.length;
        if (len==0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int[] inner=points[i];
            if (list.isEmpty()){
               list.add(inner);
            }else {
                int[] last=list.get(list.size()-1);
                if (last[1]>=inner[0] &&inner[1]>0) {
                    last[0] = Math.max(inner[0], last[0]);
                    last[1] = Math.min(inner[1], last[1]);
                }else {
                    list.add(inner);
                }
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        int[][] point={{2,8},{1,6},{7,12},{10,16}};
        int res = findMinArrowShots(point);
        System.out.println(res);
    }
}
