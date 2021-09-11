package 笔试.同城.T1;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution_1 {

    public static void main(String[] args) {
//        int[] nums={1,2,3,4,7,7,7,8,8,8};
        int[] nums={1,1};
        int res = solution(nums);
        System.out.println(res);
    }
    public static int solution (int[] source) {
        int len=source.length;
        if (len==0){
            return 0;
        }
        int last=-1;
        Map<Integer,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i < len; i++) {
            int cnt=1;
            if (map.containsKey(source[i])){
                cnt=map.get(source[i]);
                cnt++;
            }
            map.put(source[i],cnt);
        }

        for (Integer i:map.keySet()){
            if (map.get(i)==1){
                last=i;
            }
        }

        return last;

    }
}
