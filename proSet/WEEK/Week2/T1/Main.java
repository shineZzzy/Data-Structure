package LeetCode.奇安信.T1;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续子序列
 */
public class Main {

    public static void main(String[] args) {
//        int[] nums={20,40,41,41,21,22};
        int[] nums={20,20,20};
        System.out.println(MALS(nums));
    }
    public static int MALS (int[] members) {
        int len=members.length;
        if (len==0){
            return 0;
        }

        Set<Integer> set=new HashSet<>();
        for (int i : members) {
            set.add(i);
        }

        int max=0;

        for (int i = 0; i < len; i++) {
            int index=i;
            int temp=members[i]-1;
            if (set.contains(temp)){
                continue;
            }
            temp=members[i]+1;
            while (set.contains(temp)){
                index++;
                temp++;

            }
            int v=index-i+1;
            max=Math.max(max,v);
        }

        return  max;
    }
}
