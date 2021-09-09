package LeetCode.富途.T2;

import java.util.*;

/**
 * 设计LRU缓存
 * 链接：https://www.nowcoder.com/questionTerminal/e3769a5f49894d49b871c09cadd13a61
 */
public class T909 {
    public static int[] LRU (int[][] operators, int k) {
        Map<Integer,Integer> map=new LinkedHashMap<>();
        List<Integer> list=new ArrayList<>();
        for (int[] ints : operators) {
            int key=ints[1];
            //根据第0为判断接下来的操作
            //状态机
            switch (ints[0]){
                case 1:
                    //存操作
                    //如果map的容量大于k，删除最前面的一个
                    if (map.size()>=k){
                        Iterator it=map.keySet().iterator();
                        map.remove(it.next());
                    }
                    map.put(key,ints[2]);
                    break;
                case 2:
                    //取操作
                    if (map.containsKey(key)){
                        int val=map.get(key);
                        list.add(val);
                        //查找key记录，就得更新缓存，将原来的删掉，重新插入
                        map.remove(key);
                        //因为用过了，使用是目前最新记录
                        map.put(key,val);
                    }else {
                        list.add(-1);
                    }
                    break;
                default:
            }
        }

        int[] res=new int[list.size()];
        int index=0;
        for (Integer i : list) {
            res[index++]=i;
        }

        return res;
    }
}
