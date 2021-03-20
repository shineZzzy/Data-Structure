package EveryDay.Mar.Day12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163
 */

public class countOverstepNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String[] s=sc.nextLine().split(",");
            int[] n=new int[s.length];
            for (int i = 0; i < n.length; i++) {
                n[i]=Integer.parseInt(s[i]);
            }
            int res=isOverLength(n);

            System.out.println(res);
        }
    }

    public static int isOverLength(int [] array) {
        Map<Integer,Integer> map=new HashMap<>();
        int max=(array.length-1)/2;
        Arrays.sort(array);

        int count=0;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                count++;
            }else {
                count=1;
            }
            map.put(array[i],count);
        }
        for (int i = 0; i < map.size(); i++) {
            if (map.containsKey(array[i])){
                if (map.get(array[i])>max){
                    return array[i];
                }
            }
        }
        return 0;
    }

}
